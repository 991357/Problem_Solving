package Supplementary;

import java.io.*;
import java.util.*;

public class HyeonJoo
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T, count;
    static long N;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++)
        {
            count = 0;

            N = Long.parseLong(br.readLine());

            while (N != 2)
            {
                // 만약 N에 루트를 씌웠을 때 정수가 된다면
                int temp = (int) Math.sqrt(N);

                if ((long) temp * temp == N) // 루트 씌웠을 때 정수
                {
                    N = (long) Math.sqrt(N);
                    count++;
                }
                else
                {
                    int a = (int) Math.sqrt(N);
                    count += (int)((long)(a + 1) * (a + 1) - N);
                    N = (long)(a + 1) * (a + 1);
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
}