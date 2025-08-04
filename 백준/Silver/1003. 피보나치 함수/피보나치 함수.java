import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 0; test_case < T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            int zeroDp[] = new int[N + 1];
            int oneDp[] = new int[N + 1];

            zeroDp[0] = 1;
            oneDp[0] = 0;
            if(N != 0)
            {
                zeroDp[1] = 0;
                oneDp[1] = 1;
            }

            for (int i = 2; i <= N; i++)
            {
                zeroDp[i] = zeroDp[i - 1] + zeroDp[i - 2];
                oneDp[i] = oneDp[i - 1] + oneDp[i - 2];
            }

            sb.append(zeroDp[N]).append(" ").append(oneDp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
