import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] mapArr;
    static boolean[][][] visitedArr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mapArr = new int[N][M];
        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++)
                mapArr[i][j] = str.charAt(j) - '0';
        }

        System.out.println(bfs());
    }

    private static int bfs()
    {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{0, 0, 0, 1});
        visitedArr = new boolean[N][M][2];
        visitedArr[0][0][0] = true;

        while (!bfsQ.isEmpty())
        {
            int[] cur = bfsQ.poll();
            int x = cur[0];
            int y = cur[1];
            int broken = cur[2];
            int dist = cur[3];

            if(x == N - 1 && y == M - 1)
                return dist;

            for (int i = 0; i < dx.length; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && mapArr[nx][ny] == 0 && !visitedArr[nx][ny][broken])
                {
                    visitedArr[nx][ny][broken] = true;
                    bfsQ.offer(new int[]{nx, ny, broken, dist + 1});
                }

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && mapArr[nx][ny] == 1 && broken == 0 && !visitedArr[nx][ny][1])
                {
                    visitedArr[nx][ny][1] = true;
                    bfsQ.offer(new int[]{nx, ny, 1, dist + 1});
                }
            }
        }
        return -1;
    }
}