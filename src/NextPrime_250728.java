import java.io.*;

public class NextPrime_250728
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 0; test_case < T; test_case++)
        {
            long N = Long.parseLong(br.readLine());

            if(N == 0 || N == 1)
            {
                sb.append(2).append("\n"); continue;
            }

            if(isPrime(N))
                sb.append(N).append("\n");
            else
                sb.append(findPrime(N)).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrime(long n)
    {
        for (long i = 2; i <= Math.sqrt(n); i++)
        {
            if(n % i == 0)
                return false;
        }

        return true;
    }

    static long findPrime(long n)
    {
        long temp = n+1;

        while (true)
        {
            if(isPrime(temp))
                return temp;
            else
                temp++;
        }
    }
}
