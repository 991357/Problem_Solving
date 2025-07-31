import java.io.*;

public class recursive {
    static int N = 5;
    static int[][] arr = new int[N][N];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int count = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = count++;

        visitAll(0, 0); // (0,0)부터 재귀로 모든 칸 방문
    }

    // 현재 위치 방문 + 다음 위치로 이동
    static void visitAll(int x, int y) {
        System.out.println("현재 위치: (" + x + "," + y + ") 값: " + arr[x][y]);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                System.out.println("  → 인접한 위치: (" + nx + "," + ny + ") 값: " + arr[nx][ny]);
            }
        }

        // 다음 위치로 이동 (오른쪽 → 아래 순서로)
        if (y + 1 < N)
            visitAll(x, y + 1); // 오른쪽으로 이동
        else if (x + 1 < N)
            visitAll(x + 1, 0); // 다음 줄로 이동 (맨 앞 열부터)
    }
}
