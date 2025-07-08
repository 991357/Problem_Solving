/*
* 프로그래머스 Lv.2 N개의 최소 공배수 구하기
* */
class N_LCM_250708
{
    public int solution(int[] arr)
    {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++)
            answer = lcm(answer, arr[i]);

        return answer;
    }

    public static int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int lcm(int a, int b)
    {
        return a*b/gcd(a,b);
    }
}