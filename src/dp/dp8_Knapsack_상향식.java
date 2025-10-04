package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dp8_Knapsack_상향식
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
            // 상향식 dp 적용
            dp(tc);
        }
    }

    private static void dp(int tc)
    {
        int[][] dp = new int[N + 1][K + 1];
        //아이템이 N번째까지 증가
        for (int i = 1; i <= N; i++)
        {
            // dp테이블을 1번행부터 N번행까지 채워나갑시다.
            // 1번행은 첫번째 아이템 한개만 고려해서 배낭을 채워나감.
            // 2번행은 첫번째와 두번째 아이템을 고려해서 배낭을 채워나감.
            // N번행은 첫번째 + .. + N번째 아이템을 꼬려해서 배낭을 채워나감.

            // i번째 아이템을 이용해 배낭을 채울때.
            // 담을 수 있다면. (아이템의무게가 공간보다 작다면)
            // 위에 줄에서 i번째 아이템의 부피만큼 제외했을때의 최적가치 + 해당아이템의 가치와
            // 위에칸의 가치 중에서 큰 가치를 선택

            // 아니라면 (아이템의 무가가 공간보다 크다면)
            // 배낭의 부피 j가 i번째 아이템을 담을 수 없는 경우... 위에 칸의 가치를 그냥 복사.


            //가방 크기가 K 일때까지 증가
            for (int w = 1; w <= K; w++)
            {

                if (weights[i] <= w)
                    dp[i][w] = Math.max(dp[i - 1][w - weights[i]] + values[i]
                            , dp[i - 1][w]);

                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        System.out.println("#" + tc + " " + dp[N][K]);
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
