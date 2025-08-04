import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (count == 2)
        {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = Math.min(a, b);

            for (int i = 1; i <= min; i++)
            {
                if (a % i == 0 && b % i == 0)
                    System.out.print(i + " ");
            }
        }
        else if (count == 3)
        {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int min = Math.min(a, Math.min(b, c));

            for (int i = 1; i <= min; i++)
            {
                if (a % i == 0 && b % i == 0 && c % i == 0)
                    System.out.print(i + " ");
            }
        }
    }
}
