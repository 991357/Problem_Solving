import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[] arr;
    static int[] sel;
    static List<int[]> numList;

    static int winningCnt, losingCnt;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        winningCnt = 0;
        losingCnt = 0;

        numList = new ArrayList<>();

        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;
        sel = new int[M];
        
        Combination(0, 0);

        for (int i = 0; i < numList.size(); i++)
        {
            for (int j = 0; j < numList.size(); j++)
            {
                int cnt = 0;
                for (int k = 0; k < numList.get(i).length; k++)
                {
                    for (int l = 0; l < numList.get(j).length; l++)
                    {
                        if(numList.get(i)[k] == numList.get(j)[l])
                            cnt++;
                    }
                }
                if(cnt >= K)
                    winningCnt++;
                else
                    losingCnt++;
            }
        }
        System.out.println(((double)winningCnt/(winningCnt + losingCnt)));
    }

    private static void Combination(int n, int k)
    {
        if(k == M)
        {
            int[] temp = new int[sel.length];
            for (int i = 0; i < sel.length; i++)
                temp[i] = sel[i];
            numList.add(temp);
            return;
        }
        if(n == N) return;

        sel[k] = n;
        Combination(n + 1, k + 1);
        Combination(n + 1, k);
    }
}