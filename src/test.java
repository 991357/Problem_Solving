public class test
{
    static int[] arr = {1, 3, 5};

    public static void main(String[] args)
    {
        int sum = recursiveSum(0, 0);
        System.out.println("sum : " + sum);

        int mul = recursiveMul(0, 1);
        System.out.println("mul : " + mul);
    }

    static int recursiveSum(int i, int val)
    {
        if(i == arr.length)
            return val;
        return recursiveSum(i+1, val+arr[i]);
    }

    static int recursiveMul(int i, int val)
    {
        if(i == arr.length)
            return val;
        return recursiveMul(i+1, val*arr[i]);
    }
}
