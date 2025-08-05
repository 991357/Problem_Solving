import java.io.*;
import java.util.*;

public class Main
{
    static int row, col;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int scoreArr[] = new int[N];

        for(int i = 0; i < N; i++)
            scoreArr[i] = Integer.parseInt(br.readLine());

        int dp[] = new int[N + 1];

        dp[0] = scoreArr[0];
        if (N >= 2) dp[1] = scoreArr[0] + scoreArr[1];
        if (N >= 3) dp[2] = Math.max(scoreArr[0] + scoreArr[2], scoreArr[1] + scoreArr[2]);

        for (int i = 3; i < N; i++)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scoreArr[i - 1]) + scoreArr[i];

        System.out.println(dp[N - 1]);
    }
}