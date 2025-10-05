import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N = 4;
    static int[][] mapArr;
    static boolean[][] checkArr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int cnt;

    public static void main(String[] args) throws IOException
    {
        mapArr = new int[100][100];
        cnt = 0;
        checkArr = new boolean[100][100];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            for (int j = sX; j < eX; j++)
            {
                for (int k = sY; k < eY; k++)
                    mapArr[j][k] = 1;
            }
        }

        for (int i = 0; i < mapArr.length; i++)
        {
            for (int j = 0; j < mapArr[i].length; j++)
            {
                if(mapArr[i][j] == 1 && !checkArr[i][j])
                    bfs(i, j);
            }
        }

        System.out.println(cnt);
    }

    private static void bfs(int r, int c)
    {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        checkArr[r][c] = true;
        bfsQ.offer(new int[]{r, c});
        cnt++;

        while (!bfsQ.isEmpty())
        {
            int[] cur = bfsQ.poll();

            for (int i = 0; i < dx.length; i++)
            {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

               if(nx >= 0 && ny >= 0 && nx < 100 && ny < 100 && mapArr[nx][ny] == 1 && !checkArr[nx][ny])
               {
                   cnt++;
                   checkArr[nx][ny] = true;
                   bfsQ.offer(new int[]{nx, ny});
               }
            }
        }
    }
}