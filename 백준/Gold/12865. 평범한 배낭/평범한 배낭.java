import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] wArr;
    static int[] vArr;

    static int[][] dp;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wArr = new int[N];
        vArr = new int[N];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            wArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= K; j++)
            {
                // i번째 물건을 넣지 않는 경우
                dp[i][j] = dp[i - 1][j];

                // i번째 물건을 넣을 수 있는 경우
                if (wArr[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - wArr[i - 1]] + vArr[i - 1]);
            }
        }
        System.out.println(dp[N][K]);
    }
}