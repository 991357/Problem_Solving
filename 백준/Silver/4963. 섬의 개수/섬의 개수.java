import java.io.*;
import java.util.*;

public class Main
{
    static int count = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            if(col == 0 && row == 0)
                break;

            int landArr[][] = new int[row][col];

            for (int i = 0; i < row; i++)
            {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < col; j++)
                    landArr[i][j] = Integer.parseInt(st.nextToken());
            }

            boolean checkArr[][] = new boolean[row][col];

            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    if (landArr[i][j] == 1)
                        bfs(landArr, checkArr, row, col, i, j);
                }
            }

            sb.append(count).append("\n");
            count = 0;
        }
        System.out.println(sb);
    }

    private static void bfs(int[][] landArr, boolean[][] checkArr, int row, int col, int i, int j)
    {
        // 여긴 밟았다!
        checkArr[i][j] = true;
        landArr[i][j] = 0;

        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[]{i, j});

        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!bfsQ.isEmpty())
        {
            int[] pos = bfsQ.poll();
            int x = pos[0];
            int y = pos[1];

            for(int index = 0; index < 8; index++)
            {
                int nx = x + dx[index];
                int ny = y + dy[index];

                if(nx >= 0 && ny >= 0 && nx < row & ny < col && !checkArr[nx][ny] && landArr[nx][ny] == 1)
                {
                    checkArr[nx][ny] = true;
                    landArr[nx][ny] = 0;
                    bfsQ.offer(new int[]{nx, ny});
                }
            }
        }
        count++;
    }
}
