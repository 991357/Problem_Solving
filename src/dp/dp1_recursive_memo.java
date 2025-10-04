package dp;

// 1 ~ 10 더하기
public class dp1_recursive_memo
{
    static int[] memo;

    public static void main(String[] args)
    {
        // 문제 : 1 ~ 10 까지 더하기
        // 1. 인자를 이용한 재귀
        // add(1,0);

        // 2. 리턴을 이용한 재귀
        // int ans = add_return(10);
        // System.out.println(ans);

        // 3. memoization
//		memo = new int[10+1];
//		int ans = add_memo(10);
//		System.out.println(ans);
        // 여기까지가 하향식이고요

        // 4. 상향식
//		memo = new int[10 + 1];
//		add_dp();

        // 5 더하기곱하기 예제
        // 인자재귀
        //recursive_args(0, 1);

        // 리턴재귀
        int Ans = recursive_return(0);
        System.out.println(Ans);

    }

    static int[] arr = {5, 3, 1};

    private static void recursive_args(int idx, int value)
    {
        if (idx == 3)
        {
            System.out.println(value);
            return;
        }

        recursive_args(idx + 1, value + arr[idx]);
        recursive_args(idx + 1, value * arr[idx]);
    }

    private static int recursive_return(int idx)
    {
        if (idx == 3)
        {
            return 1;
        }
        return Math.max(recursive_return(idx + 1) + arr[idx], recursive_return(idx + 1) * arr[idx]);

    }

    private static void add_dp()
    {
        // 1 ~ 10 까지 더한다

//		loop n 1 .. 10
//			
//			f(n) = f(n-1) + n      // <== 점화식

        for (int i = 1; i <= 10; i++)
            memo[i] = memo[i - 1] + i; // <== 점화식

        System.out.println(memo[10]);
    }

    private static int add_memo(int i)
    {
        if (i == 0)
        {
            return 0;
        }
        // 지금은 안쓰겠지만
        // 나중에 memo 에 저장된 값을 쓰는 경우가 생긴다면
        // 함수를 호출하지말고 배열에 저장된 값을 재활용한다
        if (memo[i] != 0)
        {
            return memo[i];
        }

        // 나중에 이곳에 중국해서 올놈을 위해 현재까지의 합의 값을 저장해 논다
        return memo[i] = i + add_memo(i - 1);
    }

    private static int add_return(int i)
    {
        if (i == 0)
        {
            return 0;
        }
        // i=> 10 9 8 7 6 5 4 3 2 1
        return i + add_return(i - 1);
    }

    private static void add(int i, int sum)
    {
        if (i > 10)
        {
            System.out.println(sum);
            return;
        }

        add(i + 1, sum + i);
    }
}
