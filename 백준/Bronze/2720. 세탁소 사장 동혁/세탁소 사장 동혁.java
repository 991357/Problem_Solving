import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++)
        {
            int N = Integer.parseInt(br.readLine());

            int coinArr[] = new int[4];

            while(N != 0)
            {
                if (N >= 25)
                {
                    coinArr[0]++;
                    N -= 25;
                }
                else if(N >= 10)
                {
                    coinArr[1]++;
                    N -= 10;
                }
                else if(N >= 5)
                {
                    coinArr[2]++;
                    N -= 5;
                }
                else if(N >= 1)
                {
                    coinArr[3]++;
                    N--;
                }
            }

            for (int n : coinArr)
                sb.append(n).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
