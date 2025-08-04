import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        long numerator = (long)a1 * b2 + (long)a2 * b1;
        long denominator = (long)b1 * b2;

        long gcd = GCD(numerator, denominator);

        System.out.println((numerator / gcd) + " " + (denominator / gcd));
    }

    public static long GCD(long a, long b) 
    {
        while (b != 0) 
        {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
