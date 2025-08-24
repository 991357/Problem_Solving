import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, X, left, right, temp, totalCount;
    static int[] numArr;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numArr);
        X = Integer.parseInt(br.readLine());

        left = 0;
        right = N - 1;

        while (left < right)
        {
            temp = numArr[left] + numArr[right];

            if(temp == X)
            {
                left++;
                totalCount++;
            }
            else if(temp <= X)
                left++;
            else
                right--;
        }
        System.out.println(totalCount);
    }
}
