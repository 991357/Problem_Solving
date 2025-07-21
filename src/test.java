import java.io.*;
import java.util.*;

public class test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();

            for (int j = 0; j < N; j++)
                arr[i][j] = str.charAt(j) - '0';
        }

        int maxSum = 0;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int sum = arr[i][j];
                if (i-1 >= 0)   sum += arr[i-1][j];
                if (i+1 < N)    sum += arr[i+1][j];
                if (j-1 >= 0)   sum += arr[i][j-1];
                if (j+1 < N)    sum += arr[i][j+1];

                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }
}
