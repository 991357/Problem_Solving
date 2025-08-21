import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static int[][] mapArr;
    static int[][] timeArr;
    static boolean[][] checkArr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++)
        {
            N = Integer.parseInt(br.readLine());

            mapArr = new int[N][N];
            timeArr = new int[N][N];
            checkArr = new boolean[N][N];

            for (int i = 0; i < N; i++)
            {
                String str = br.readLine();
                for (int j = 0; j < N; j++)
                    mapArr[i][j] = str.charAt(j) - '0';
            }

            bfs();

            sb.append('#').append(t).append(' ').append(timeArr[N - 1][N - 1]).append('\n');
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb.toString());
    }

    private static void bfs()
    {
        final int INF = 123456789;

        for (int i = 0; i < N; i++)
            Arrays.fill(timeArr[i], INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                return Integer.compare(a[0], b[0]);
            }
        });

        timeArr[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty())
        {
            int[] cur = pq.poll();
            int cost = cur[0], x = cur[1], y = cur[2];

            if (checkArr[x][y]) continue;
            checkArr[x][y] = true;

            if (x == N - 1 && y == N - 1) return;

            for (int dir = 0; dir < 4; dir++)
            {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (checkArr[nx][ny]) continue;

                int nCost = cost + mapArr[nx][ny];
                if (nCost < timeArr[nx][ny])
                {
                    timeArr[nx][ny] = nCost;
                    pq.offer(new int[]{nCost, nx, ny});
                }
            }
        }
    }
}