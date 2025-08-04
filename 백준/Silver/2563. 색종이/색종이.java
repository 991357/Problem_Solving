import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numArr[][] = new int[100][100];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            x--;
            y--;

            for (int j = x; j < x + 10; j++)
            {
                for (int k = y; k < y + 10; k++)
                    if(numArr[j][k] == 0)
                        numArr[j][k] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                sum += numArr[i][j];

        System.out.println(sum);
    }
}
