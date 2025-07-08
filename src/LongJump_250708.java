/*
* 프로그래머스 Lv.2 멀리뛰기
* */
class LongJump_250708
{
    public long solution(int n)
    {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
