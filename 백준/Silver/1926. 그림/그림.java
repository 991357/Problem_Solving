import java.io.*;
import java.util.*;

public class Main
{
    static int artCount = 0;
    static int artArea = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int artArr[][] = new int[M][N];

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                artArr[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] checkArr = new boolean[M][N];

        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(artArr[i][j] == 1)
                {
                    bfs(artArr, checkArr, M, N, i, j);
                    artCount++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(artCount).append("\n").append(artArea);
        System.out.println(sb);
    }

    private static void bfs(int[][] artArr, boolean[][] checkArr, int m, int n, int startRow, int startCol)
    {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[]{startRow, startCol});
        checkArr[startRow][startCol] = true;

        int count = 1;

        while (!bfsQ.isEmpty())
        {
            int pos[] = bfsQ.poll();

            for(int i = 0; i < 4; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !checkArr[nx][ny] && artArr[nx][ny] == 1)
                {
                    checkArr[nx][ny] = true;
                    artArr[nx][ny] = 0;
                    bfsQ.offer(new int[]{nx,ny});
                    count++;
                }
            }
        }

        artArea = Math.max(artArea, count);
    }
}