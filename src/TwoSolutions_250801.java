import java.io.*;
import java.util.*;

public class TwoSolutions_250801
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int ansL = 0, ansR = 0;

        while(left < right)
        {
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < minSum)
            {
                minSum = Math.abs(sum);
                ansL = arr[left];
                ansR = arr[right];
            }

            if(sum < 0)
                left++;
            else
                right--;
        }
        System.out.println(ansL + " " + ansR);
    }
}
