package dp;

public class dp7_막대기_상향식
{
    /*
     *
     * 1. 파, 노 2. (파, 파),(파, 노),(노, 파),(노, 노), 빨 3. (파, 파, 파),(파, 파, 노),(파, 노,
     * 파),(파, 노, 노), (노, 파, 파), (노, 파, 노), (노, 파, 파), (노, 노, 노)
     *
     *
     * 점화식 유도 길이가 𝑛 ncm인 막대를 만들려면, 마지막에 어떤 색의 막대를 놓았는지를 기준으로 나눠서 생각할 수 있습니다.
     * 1. 마지막 막대가 파란색(B)인 경우 이 경우, 길이가 (n-1)cm인 막대 뒤에 파란색(B)을 추가한 것입니다.
     * 즉, f(n−1)개의 경우에서 각각 끝에 B를 붙이면 됨.
     * 그러므로 가능한 경우의 수는 f(n−1)
     * 2️. 마지막 막대가 노란색(Y)인 경우 이 경우도 길이가 (n-1)cm인 막대 뒤에 노란색(Y)을 추가한 것입니다.
     * 즉, f(n−1)개의 경우에서 각각 끝에 Y를 붙이면 됨.
     * 그러므로 가능한 경우의 수는 f(n−1)
     * 3️. 마지막 막대가 빨간색(R)인 경우 이 경우는 길이가 (n-2)cm인 막대 뒤에 빨간색(R)을 추가한 것입니다.
     *
     * 즉, f(n−2)개의 경우에서 각각 끝에 R을 붙이면 됨.
     *
     * 그러므로 가능한 경우의 수는 f(n−2)
     *
     * 위 세 가지 경우를 모두 합치면:
     *
     * f(n)=f(n−1)+f(n−1)+f(n−2) = 2f(n−1)+f(n−2)
     *
     */
    public static void main(String[] args)
    {

        // 하향식
        System.out.println(getStrick(6));
        System.out.println(getStrick2(6));
        // 상향식
        System.out.println(getStrick3(6));
        // System.out.println(Arrays.toString(memo));
    }

    // 상향식
    private static int getStrick3(int n)
    {
        int[] dp = new int[10000];
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i <= n; i++)
        {
            // f(n) = 2(n-1) + n-2;
            dp[i] = 2 * dp[i - 1] + dp[i - 2];
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    // 하향식
    static int[] memo = new int[10000];

    static
    {
        memo[1] = 2;
        memo[2] = 5;
    }

    private static int getStrick2(int n)
    {
        if (memo[n] == 0)
            memo[n] = getStrick2(n - 2) + getStrick2(n - 1) * 2;
        return memo[n];
    }

    private static int getStrick(int n)
    {
        if (n == 1)
            return 2;
        if (n == 2)
            return 5;
        return getStrick(n - 2) + getStrick(n - 1) * 2;
    }

}
