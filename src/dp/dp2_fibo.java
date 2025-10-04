package dp;

public class dp2_fibo
{
    // -------------- 이부분은 fibo_2 에서 설명
    public static long fiboDP(int n)
    {
        long[] fibo = new long[n + 1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 2; i <= n; i++)
        {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }

    // ---------------- 여기까지 하고 위의 내용은 상향식 설명
    static long[] memo;

    public static long fiboReturnMemo(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 1;
        }
        if (memo[n] != 0) return memo[n];
        return memo[n] = fiboReturnMemo(n - 1) + fiboReturnMemo(n - 2);
    }

    public static long fiboReturn(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 1;
        }

        return fiboReturn(n - 1) + fiboReturn(n - 2);
    }

    private static int fiboLoop(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
        {
            return 1;
        }

        int a = 0, b = 1;
        for (int i = 0; i < n - 1; i++)
        {
            int tmp = a;
            a = b;
            b = tmp + b;
        }
        return b;
    }


    public static void main(String[] args)
    {

        int N = 10;

        memo = new long[N + 1];
        System.out.printf("%d번째 수열 : %d \n", N, fiboLoop(N));
        long start = System.currentTimeMillis();
        //System.out.printf("%d번째 수열 : %d \n",N,  fiboReturn(N));
//		System.out.printf("%d번째 수열 : %d \n",N,  fiboMemo(N));
//		System.out.printf("%d번째 수열 : %d \n",N,  fiboDP(N));
        long end = System.currentTimeMillis();
//		1134903170 
        System.out.printf("%d번째 수열을 구하는데 걸린 시간 : %dms"
                , N, end - start);
    }

}
