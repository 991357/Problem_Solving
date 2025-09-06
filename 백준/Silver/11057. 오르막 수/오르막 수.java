import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[10];

        for (int i = 0; i <= 9; i++)
            dp[i] = 1;

        for (int i = 2; i <= N; i++)
        {
            for (int j = 1; j <= 9; j++)
                dp[j] = (dp[j] + dp[j - 1]) % 10007;
        }

        int result = 0;
        
        for (int i = 0; i <= 9; i++)
            result = (result + dp[i]) % 10007;

        System.out.println(result);
    }
}