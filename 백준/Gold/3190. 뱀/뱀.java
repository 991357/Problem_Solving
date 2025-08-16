import java.io.*;
import java.util.*;

class Hebi {
    Deque<int[]> HebiPosQ;
    Hebi(int x, int y) {
        HebiPosQ = new ArrayDeque<>();
        HebiPosQ.offer(new int[]{x - 1, y - 1});
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, L, totalTime, curDir;
    static int[][] mapArr;
    static Deque<Integer> nextTimeQ;
    static Deque<Character> nextDirectionQ;
    static Hebi hebi;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        mapArr = new int[N][N];
        hebi = new Hebi(1, 1);
        curDir = 3; // 오른쪽
        totalTime = 0;

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            mapArr[x - 1][y - 1] = 1;
        }

        nextTimeQ = new ArrayDeque<>();
        nextDirectionQ = new ArrayDeque<>();
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            nextTimeQ.offer(time);
            nextDirectionQ.offer(dir);
        }

        // 명령 처리
        while (!nextDirectionQ.isEmpty()) {
            int targetTime = nextTimeQ.poll();
            char dir = nextDirectionQ.poll();
            int move = targetTime - totalTime;

            if (!moveSnake(move)) { // 이동 중 충돌나면 종료
                System.out.println(totalTime);
                return;
            }
            ChangeDir(dir);
        }

        // 남은 명령 없을 때는 직진하다가 충돌날 때까지
        moveSnake(Integer.MAX_VALUE);
        System.out.println(totalTime);
    }

    // move칸 이동 시뮬
    private static boolean moveSnake(int move) {
        for (int i = 0; i < move; i++) {
            int[] head = hebi.HebiPosQ.peekFirst();
            int nx = head[0] + dx[curDir];
            int ny = head[1] + dy[curDir];

            totalTime++;

            // 벽 충돌
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) return false;

            // 몸 충돌
            if (contains(nx, ny)) return false;

            // 머리 추가
            hebi.HebiPosQ.offerFirst(new int[]{nx, ny});

            // 사과 여부
            if (mapArr[nx][ny] == 1) {
                mapArr[nx][ny] = 0; // 사과 먹으면 꼬리 유지
            } else {
                hebi.HebiPosQ.pollLast(); // 사과 없으면 꼬리 제거
            }
        }
        return true;
    }

    private static boolean contains(int x, int y) {
        for (int[] pos : hebi.HebiPosQ) {
            if (pos[0] == x && pos[1] == y) return true;
        }
        return false;
    }

    private static void ChangeDir(char dir) {
        switch (curDir) {
            case 0: curDir = (dir == 'L') ? 2 : 3; break;
            case 1: curDir = (dir == 'L') ? 3 : 2; break;
            case 2: curDir = (dir == 'L') ? 1 : 0; break;
            case 3: curDir = (dir == 'L') ? 0 : 1; break;
        }
    }
}
