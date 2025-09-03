import java.io.*;
import java.util.Arrays;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = -1;
        if(N >= 2)
            dp[2] = 1;
        if(N >= 3)
            dp[3] = -1;
        if(N >= 4)
            dp[4] = 2;

        for (int i = 5; i <= N; i++)
        {
            if(dp[i - 5] != -1 && dp[i - 2] != -1)
                dp[i] = Math.min(dp[i - 5] + 1, dp[i - 2] + 1);
            else if(dp[i - 5] == -1)
                dp[i] = dp[i - 2] + 1;
            else if(dp[i - 2] == -1)
                dp[i] = dp[i - 5] + 1;
        }

        System.out.println(dp[N]);
    }
}