import java.io.*;
import java.util.*;

public class Main
{
    static int count = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int boxArr[][] = new int[M][N];
        Queue<int[]> tomatoQueue = new ArrayDeque<>();

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
            {
                boxArr[i][j] = Integer.parseInt(st.nextToken());
                if(boxArr[i][j] == 1)
                    tomatoQueue.offer(new int[]{i, j});
            }
        }

        bfs(tomatoQueue,boxArr, M, N);

        int max = 0;

        for(int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (max < boxArr[i][j])
                    max = boxArr[i][j];

                if (boxArr[i][j] == 0)
                {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max - 1);
    }

    private static void bfs(Queue<int[]> tomatoQueue,int[][] boxArr,  int M, int N)
    {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        while (!tomatoQueue.isEmpty())
        {
            int[] pollPos = tomatoQueue.poll();
            int x = pollPos[0];
            int y = pollPos[1];

            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N)
                {
                    if(boxArr[nx][ny] == 0)
                    {
                        boxArr[nx][ny] = boxArr[x][y] + 1;
                        tomatoQueue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
