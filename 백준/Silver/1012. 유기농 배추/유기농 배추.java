import java.io.*;
import java.util.*;

public class Main
{
    static int row, col;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test_case = 0; test_case < N; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int cabbageCount = Integer.parseInt(st.nextToken());

            int cabbageArr[][] = new int[row][col];
            boolean checkArr[][] = new boolean[row][col];

            int count = 0;

            for(int i = 0; i < cabbageCount; i++)
            {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                cabbageArr[x][y] = 1;
            }

            // 탐색
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(cabbageArr[i][j] == 1)
                    {
                        bfs(cabbageArr, checkArr, i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int[][] cabbageArr, boolean[][] checkArr, int startRow , int startCol)
    {
        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[]{startRow, startCol});
        checkArr[startRow][startCol] = true;

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        // bfs
        while (!bfsQ.isEmpty())
        {
            int[] pos = bfsQ.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < row && ny < col && !checkArr[nx][ny] && cabbageArr[nx][ny] == 1)
                {
                    checkArr[nx][ny] = true;
                    cabbageArr[nx][ny] = 0;
                    bfsQ.offer(new int[]{nx, ny});
                }
            }
        }
    }
}