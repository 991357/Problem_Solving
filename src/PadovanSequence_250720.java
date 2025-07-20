import java.io.*;
import java.util.*;

public class PadovanSequence_250720
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb=  new StringBuilder();

        for (int test_case = 0; test_case < T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            long dp[] = new long[N + 1];

            dp[1] = 1;
            if(N > 1)
                dp[2] = 1;
            if(N > 2)
            {
                for (int i = 3; i <= N; i++)
                    dp[i] = dp[i -3] + dp[i - 2];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
