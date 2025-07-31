import java.io.*;
import java.util.*;

public class BertrandPostulate_250728
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.print(sb);
                return;
            }

            sb.append(countingPrime(N)).append("\n");
        }
    }

    static int countingPrime(int n) {
        int count = 0;

        for (int i = n + 1; i <= 2 * n; i++) {
            if (isPrime(i))
                count++;
        }

        return count;
    }

    static boolean isPrime(int n)
    {
        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
