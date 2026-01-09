import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int H, W, R, C, D;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] ruleA, ruleB;
    static boolean[][] cleaned;

    static boolean[][][] visited; // non-clean 구간에서만 사용
    static int streak;            // 마지막 청소 이후 "연속으로 청소 못한 이동 수"
    static long totalMoves;       // 영역 안에서 실제로 이동한 횟수 누적
    static long answer;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        ruleA = new int[H][W];
        ruleB = new int[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                ruleA[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                ruleB[i][j] = s.charAt(j) - '0';
            }
        }

        cleaned = new boolean[H][W];
        visited = new boolean[H][W][4];
        streak = 0;
        totalMoves = 0;

        int r = R, c = C, d = D;

        while (true) {
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                visited = new boolean[H][W][4];
                streak = 0;

                d = (d + ruleA[r][c]) & 3;

                int nr = r + dx[d];
                int nc = c + dy[d];
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    answer = totalMoves + 1;
                    break;
                }

                r = nr;
                c = nc;

                totalMoves++;
            } else {
                if (visited[r][c][d]) {
                    answer = totalMoves - streak;
                    break;
                }
                visited[r][c][d] = true;

                d = (d + ruleB[r][c]) & 3;

                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    answer = totalMoves - streak;
                    break;
                }

                r = nr;
                c = nc;
                
                totalMoves++;
                streak++;
            }
        }

        System.out.println(answer);
    }
}
