package Supplementary;

import java.io.*;
import java.util.*;

public class JangHoon
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int T, N, B, MIN;
    static int[] heights;

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new StringReader(inStr));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++)
        {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++)
                heights[n] = Integer.parseInt(st.nextToken());

            MIN = Integer.MAX_VALUE;

            subSet(0, 0);

            sb.append("#").append(t).append(" ").append(MIN).append("\n");
        }

        System.out.println(sb);
    }

    static void subSet(int idx, int sum)
    {
        // 3 가지치기
        if(sum - B >= MIN)
            return;

        // 2. 기저
        if(idx == N)
        {
            if(sum >= B)
                MIN = Math.min(sum - B, MIN);
            return;
        }

        // 1 재귀
        subSet(idx + 1, sum);
        subSet(idx + 1, sum + heights[idx]);
    }

    private static String inStr = "1\n" +
            "5 16\n" +
            "1 3 3 5 6";
}

