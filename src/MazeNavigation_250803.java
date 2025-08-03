import java.io.*;
import java.util.*;

public class MazeNavigation_250803
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int mazeArr[][] = new int[row][col];

        for(int i = 0; i < row; i++)
        {
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++)
                mazeArr[i][j] = str.charAt(j) - '0';
        }

        boolean check[][] = new boolean[row][col];

        bfs(mazeArr, check, row, col);

        System.out.println(mazeArr[row - 1][col - 1]);
    }

    private static void bfs(int[][] mazeArr, boolean[][] check, int row, int col)
    {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        Queue<int[]> mazeQ = new LinkedList<>();

        mazeQ.offer(new int[]{0,0});
        check[0][0] = true;

        while (!mazeQ.isEmpty())
        {
            int cur[] = mazeQ.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < row && ny < col && !check[nx][ny] && mazeArr[nx][ny] == 1)
                {
                    check[nx][ny] = true;
                    mazeArr[nx][ny] = mazeArr[x][y] + 1;
                    mazeQ.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

// https://www.acmicpc.net/problem/2178
