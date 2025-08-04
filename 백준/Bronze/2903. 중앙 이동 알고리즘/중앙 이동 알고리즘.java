import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[] = new int[N + 1];

        dp[0] = 2;

        for (int i = 1; i <= N; i++)
            dp[i] = dp[i-1] + (dp[i-1] - 1);

        System.out.println(dp[N] * dp[N]);
    }
}
