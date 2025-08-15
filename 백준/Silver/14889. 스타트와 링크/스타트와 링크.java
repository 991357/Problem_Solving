import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static int[][] teamArr;

    static Deque<int[]> caseList;

    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        teamArr = new int[N][N];
        caseList = new ArrayDeque<>();

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                teamArr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 원본 배열
        int[] arr = new int[N];
        for (int i = 1; i <= N; i++)
            arr[i - 1] = i;

        // 선택 배열
        int[] sel = new int[N / 2];

        OriginalCombination(arr, sel, 0, 0, N / 2);

        while (!caseList.isEmpty())
        {
            int[] firstSel = caseList.pollFirst();
            int[] lastSel = caseList.pollLast();

            GetSynergy(firstSel, lastSel);
        }

        System.out.println(MIN);
    }

    private static void GetSynergy(int[] firstSel, int[] lastSel)
    {
        // firstSel 에서 값 가져오기
        int beforeSum = 0;

        for (int i = 0; i < firstSel.length; i++)
        {
            for (int j = i + 1; j < firstSel.length; j++)
            {
                beforeSum += teamArr[firstSel[i] - 1][firstSel[j] - 1];
                beforeSum += teamArr[firstSel[j] - 1][firstSel[i] - 1];
            }
        }

        int afterSum = 0;

        // lastSel 에서 값 가져오기
        for (int i = 0; i < lastSel.length - 1; i++)
        {
            for (int j = i + 1; j < lastSel.length; j++)
            {
                afterSum += teamArr[lastSel[i] - 1][lastSel[j] - 1];
                afterSum += teamArr[lastSel[j] - 1][lastSel[i] - 1];
            }
        }

        int sum = Math.abs(beforeSum - afterSum);

        MIN = Math.min(sum, MIN);
    }

    private static void OriginalCombination(int[] arr, int[] sel, int idx, int k, int goal)
    {
        // b
        if (k == goal)
        {
            int[] temp = new int[sel.length];

            for (int i = 0; i < temp.length; i++)
                temp[i] = sel[i];

            caseList.add(temp);

            return;
        }

        if (idx == N)
            return;

        // i
        sel[k] = arr[idx];
        OriginalCombination(arr, sel, idx + 1, k + 1, goal);
        OriginalCombination(arr, sel, idx + 1, k, goal);
    }
}