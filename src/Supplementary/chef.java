package Supplementary;

import java.io.*;
import java.util.*;

public class chef
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N;

    static int[][] synergyArr;

    static Deque<int[]> caseList;

    static int MIN;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++)
        {
            MIN = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            synergyArr = new int[N][N];
            caseList = new ArrayDeque<>();

            for(int i = 0; i < N; i++)
            {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++)
                    synergyArr[i][j] = Integer.parseInt(st.nextToken());
            }

            // 원본 배열
            int[] arr = new int[N];
            for(int i = 1; i <= N; i++)
                arr[i-1] = i;

            // 선택 배열
            int[] sel = new int[N/2];

            OriginalCombination(arr, sel, 0, 0, N/2);

            while (!caseList.isEmpty())
            {
                int[] firstSel = caseList.pollFirst();
                int[] lastSel = caseList.pollLast();

                GetSynergy(firstSel, lastSel);
            }

            sb.append("#").append(t).append(" ").append(MIN).append("\n");
        }
        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void GetSynergy(int[] firstSel, int[] lastSel)
    {
        // firstSel 에서 값 가져오기
        int beforeSum = 0;

        for(int i = 0; i < firstSel.length; i++)
        {
            for(int j = i + 1; j < firstSel.length; j++)
            {
                //System.out.println((firstSel[i])+ " , " + (firstSel[j]));

                beforeSum += synergyArr[firstSel[i] - 1][firstSel[j] - 1];
                beforeSum += synergyArr[firstSel[j] - 1][firstSel[i] - 1];
            }
        }

        int afterSum = 0;

        // lastSel 에서 값 가져오기
        for(int i = 0; i < lastSel.length - 1; i++)
        {
            for(int j = i + 1; j < lastSel.length; j++)
            {
                //System.out.println((lastSel[i])+ " , " + (lastSel[j]));

                afterSum += synergyArr[lastSel[i] - 1][lastSel[j] - 1];
                afterSum += synergyArr[lastSel[j] - 1][lastSel[i] - 1];
            }
        }

        int sum = Math.abs(beforeSum - afterSum);
        //System.out.println("합 : " + sum);

        MIN = Math.min(sum, MIN);
    }


    private static void OriginalCombination(int[] arr, int[] sel, int idx, int k, int goal)
    {
        // b
        if(k == goal)
        {
            //System.out.println(Arrays.toString(sel));
            int[] temp = new int[sel.length];

            for(int i = 0; i < temp.length; i++)
                temp[i] = sel[i];

            caseList.add(temp);

            return;
        }

        if(idx == N)
            return;

        // i
        sel[k] = arr[idx];
        OriginalCombination(arr, sel, idx + 1, k + 1, goal);
        OriginalCombination(arr, sel, idx + 1, k, goal);
    }
}
