import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Character[][] colorArr = new Character[N][N];
        Character[][] colorRGArr = new Character[N][N];
        boolean[][] checkArr = new boolean[N][N];
        int areaArr[] = new int[3];

        for(int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++)
                colorArr[i][j] = str.charAt(j);
        }

        // 적록색약 배열
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (colorArr[i][j] == 'G')
                    colorRGArr[i][j] = 'R';
                else
                    colorRGArr[i][j] = colorArr[i][j];
            }
        }

        while (true)
        {
            boolean isKeep = false;

            L: for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (!checkArr[i][j])
                    {
                        isKeep = true;
                        Character target = colorArr[i][j];
                        bfs(colorArr, checkArr, N, i, j, target);

                        if (target == 'R') areaArr[0]++;
                        else if (target == 'G') areaArr[1]++;
                        else if (target == 'B') areaArr[2]++;

                        break L;
                    }
                }
            }

            if (!isKeep)
                break;
        }

        int normalCount = areaArr[0] + areaArr[1] + areaArr[2];

        checkArr = new boolean[N][N]; // 방문 배열 초기화
        int rgCount = 0;

        while (true)
        {
            boolean isKeep = false;

            L : for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (!checkArr[i][j])
                    {
                        isKeep = true;
                        Character target = colorRGArr[i][j];
                        bfs(colorRGArr, checkArr, N, i, j, target);

                        rgCount++;
                        break L;
                    }
                }
            }

            if(!isKeep)
                break;
        }

        System.out.println(normalCount + " " + rgCount);
    }

    private static void bfs(Character[][] colorArr, boolean[][] checkArr, int N, int row, int col, Character target)
    {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[]{row, col});

        while (!bfsQ.isEmpty())
        {
            int pos[] = bfsQ.poll();
            int x = pos[0];
            int y = pos[1];

            checkArr[x][y] = true;

            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && colorArr[nx][ny] == target && !checkArr[nx][ny])
                {
                    checkArr[nx][ny] = true;
                    bfsQ.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
