import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int numArr[][] = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
                numArr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int dp[][] = new int[N][N];
        CalcPrefix(numArr, dp);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());

            sb.append(prefix(dp, startRow, startCol, endRow, endCol)).append("\n");
        }
        System.out.println(sb);
    }

    private static int prefix(int dp[][], int startRow, int startCol, int endRow, int endCol)
    {
        int count = 0;

        for(int i = startRow - 1; i < endRow; i++)
        {
            int temp = startCol - 2;
            if(temp < 0)
                count += dp[i][endCol - 1];
            else
                count += dp[i][endCol - 1] - dp[i][temp];
        }

        return count;
    }

    private static void CalcPrefix(int[][] numArr, int[][] dp)
    {
        for(int i = 0; i < numArr.length; i++)
        {
            for(int j = 0; j < numArr.length; j++)
            {
                if(j == 0)
                    dp[i][j] = numArr[i][j];
                else
                {
                    for(int k = 0; k <= j; k++)
                        dp[i][j] += numArr[i][k];
                }
            }
        }
    }
}

