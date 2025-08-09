import java.io.*;
import java.util.*;

public class Main
{
    static int totalCount = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int eleArr[][] = new int[M][N];

        for(int i = 0; i < M; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++)
                eleArr[i][j] = str.charAt(j) - '0';
        }

        boolean isCan = false;

        for(int i = 0; i < N; i++)
        {
            if(eleArr[0][i] == 0)
            {
                boolean check[][] = new boolean[M][N];
                
                int eleArrTemp[][] = new int[M][N];
                eleArrTemp = copyArr(eleArrTemp, eleArr);

                isCan = dfs(eleArrTemp, check, 0, i, M, N);

                if(isCan)
                    break;
            }
        }

        if(isCan)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static int[][] copyArr(int[][] eleArrTemp, int[][] eleArr)
    {
        for(int i = 0; i < eleArr.length; i++)
        {
            for(int j = 0; j < eleArr[i].length; j++)
                eleArrTemp[i][j] = eleArr[i][j];
        }

        return eleArrTemp;
    }

    private static boolean dfs(int[][] eleArr, boolean[][] check, int startRow, int startCol, int m, int n)
    {
        check[startRow][startCol] = true;
        Stack<int[]> dfsStack = new Stack<>();
        dfsStack.push(new int[]{startRow, startCol});

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        while (!dfsStack.isEmpty())
        {
            int pos[] = dfsStack.pop();

            if(pos[0] == m - 1)
                return true;

            for(int i = 0; i < 4; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];


                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !check[nx][ny] && eleArr[nx][ny] == 0)
                {
                    check[nx][ny] = true; // 간 길
                    eleArr[nx][ny] = 1; // 간 길
                    dfsStack.push(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}