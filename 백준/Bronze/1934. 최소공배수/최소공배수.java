import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case ++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            sb.append(lcm(a,b) + "\n");
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int lcm(int a, int b)
    {
        return (a*b) / gcd(a,b);
    }
}
