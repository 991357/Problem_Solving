package Supplementary;

import java.io.*;
import java.util.*;

public class JunHwan
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N;
    static int[] weights;
    static int A;
    static int total;

    static int[][] memo; // memo[l][b] 왼쪽무게, 상태 bit 에서의 성공한 가짓수 저장하기

    public static void main(String[] args) throws IOException
    {
        br = new BufferedReader(new StringReader(inStr));

        T = Integer.parseInt(br.readLine());
        total = 0;

        for(int t = 1; t <= T; t++)
        {
            N = Integer.parseInt(br.readLine());

            weights = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int n = 0; n < N; n++)
            {
                weights[n] = Integer.parseInt(st.nextToken());
                total += weights[n];
            }

            A = 0;
            memo = new int[total + 1][1 << N];

            A = permutationBitMemo(0,0,0,0);

            sb.append("#").append(t).append(" ").append(A).append("\n");
        }
        System.out.println(sb);
    }

    static void permutation(int idx, boolean[] visited, int sumL, int sumR)
    {
        // 3. 가지치기 (옵션)
        if(sumL < sumR)
            return;

        // 2. 기저 상황 정리 -> 저울에 추를 다 배치한 상황
        if(idx == N)
        {
            A++;
            return;
        }

        // 1. 재귀 상황 정리
        for(int n = 0; n < N; n++)
        {
            if(!visited[n])
            {
                visited[n] = true;

                // 오른쪽으로 선택하는지 왼쪽으로 선택하는지 선택 해야함
                permutation(idx + 1, visited, sumL + weights[n], sumR); // 왼쪽에 선택한 경우
                permutation(idx + 1, visited, sumL, sumR + weights[n]);

                visited[n] = false;
            }
        }
    }

    static void permutationBit(int idx, int status, int sumL, int sumR)
    {
        // 3. 가지치기 (옵션)
        if(sumL < sumR)
            return;

        // 2. 기저 상황 정리 -> 저울에 추를 다 배치한 상황
        if(idx == N)
        {
            A++;
            return;
        }

        // 1. 재귀 상황 정리
        for(int n = 0; n < N; n++)
        {
            if((status & 1 << n) == 0)
            {
                // 오른쪽으로 선택하는지 왼쪽으로 선택하는지 선택 해야함
                permutationBit(idx + 1, status | 1<< n, sumL + weights[n], sumR); // 왼쪽에 선택한 경우
                permutationBit(idx + 1, status | 1<< n, sumL, sumR + weights[n]);
            }
        }
    }

    static int permutationBitMemo(int idx, int status, int sumL, int sumR)
    {
        // 3. 가지치기 (옵션)
        if(sumL < sumR)
            return 0;

        if(memo[sumL][status] != 0) // 메모에 이미 값이 있었다면
            return memo[sumL][status];

        // 2. 기저 상황 정리 -> 저울에 추를 다 배치한 상황
        if(idx == N)
            return 1;

        int cnt = 0;

        // 1. 재귀 상황 정리
        for(int n = 0; n < N; n++)
        {
            if((status & 1 << n) == 0)
            {
                // 오른쪽으로 선택하는지 왼쪽으로 선택하는지 선택 해야함
                cnt += permutationBitMemo(idx + 1, status | 1<< n, sumL + weights[n], sumR); // 왼쪽에 선택한 경우
                cnt += permutationBitMemo(idx + 1, status | 1<< n, sumL, sumR + weights[n]);
            }
        }
        return memo[sumL][status] = cnt;
    }

    private static String inStr = "3\n" +
            "3\n" +
            "1 2 4\n" +
            "3\n" +
            "1 2 3\n" +
            "9\n" +
            "1 2 3 5 6 4 7 8 9";
}
