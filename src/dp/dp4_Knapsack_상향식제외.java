package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dp4_Knapsack_상향식제외
{
    static int T, Ans, N, K;
    static int[] weights;
    static int[] values;
    static int[][] memo;

    public static void main(String[] args) throws FileNotFoundException
    {
        System.setIn(new FileInputStream("res/넵섹.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++)
        {
            Ans = 0;
            N = sc.nextInt();
            K = sc.nextInt();
            //System.out.println(N+","+K);
            weights = new int[N + 1];
            values = new int[N + 1];
            for (int i = 1; i <= N; i++)
            {
                weights[i] = sc.nextInt();
                values[i] = sc.nextInt();

            }
            // 조합
            dfs(1, 0, 0);
            System.out.println("#" + tc + " " + Ans);
            Ans = 0;
            // 조합 2 value 를 return 으로 (하향식)
            Ans = dfs2(0, 0);
            System.out.println("#" + tc + " " + Ans);
            Ans = 0;
            // 조합2에 메모이제이젼 적용
            memo = new int[N + 1][K + 1];
            Ans = dfs_memo(1, 0);
            System.out.println("#" + tc + " " + Ans);
            Ans = 0;

        }
    }

    private static void dfs(int idx, int weight, int value)
    {
        if (idx == N + 1)
        {
            if (weight > K)
                return;
            Ans = Math.max(Ans, value);
            return;
        }

        dfs(idx + 1, weight, value);
        dfs(idx + 1, weight + weights[idx], value + values[idx]);
    }

    private static int dfs2(int idx, int weight)
    {
        if (idx == N + 1)
        {
            return 0;
        }
        if (weight + weights[idx] > K)
        {
            return dfs2(idx + 1, weight);
        } else
        {
            return Math.max(dfs2(idx + 1, weight), values[idx] + dfs2(idx + 1, weight + weights[idx]));
        }
    }

    private static int dfs_memo(int idx, int weight)
    {
        if (idx == N + 1)
        {
            // System.out.println(idx+":"+weight+": endendendendendendendendend");
            // print(memo);
            return 0;
        }
        if (memo[idx][weight] != 0)
        {
            return memo[idx][weight];
        }

        if (weight + weights[idx] > K)
        {
            memo[idx][weight] = dfs_memo(idx + 1, weight);
            return memo[idx][weight];
        } else
        {
//			int r2 = values[idx] + dfs_memo(idx + 1, weight + weights[idx]);
//			int r1 = dfs_memo(idx + 1, weight);
//			memo[idx][weight] = Math.max(r1, r2);
//			return memo[idx][weight];

            return memo[idx][weight] = Math.max(dfs_memo(idx + 1, weight),
                    values[idx] + dfs_memo(idx + 1, weight + weights[idx]));
        }
    }

    private static void print(int[][] memo)
    {
        for (int i = 1; i < memo.length; i++)
        {
            for (int j = 0; j < memo[i].length; j++)
            {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
