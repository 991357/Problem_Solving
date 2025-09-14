import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] numArr;
    static int[] dp;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());

        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        for (int i = 0; i < N; i++)
            dp[i] = numArr[i];

        for (int i = 1; i < N; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if(numArr[j] < numArr[i])
                    dp[i] = Math.max(dp[i] , dp[j] + numArr[i]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}