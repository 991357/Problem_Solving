import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++)
        {
            int n, k;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[] numArr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                numArr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(numArr);

            int start = 0;
            int end = n - 1;
            int cnt = 0;
            int diff = Integer.MAX_VALUE;

            while(start < end)
            {
                int temp = numArr[start] + numArr[end];
                int diffTemp = Math.abs(temp - k);

                if(diffTemp == diff)
                    cnt++;
                else if(diffTemp < diff)
                {
                    diff = diffTemp;
                    cnt = 1;
                }

                if(temp < k)
                    start++;
                else if(temp > k)
                    end--;
                else
                {
                    start++;
                    end--;
                }
            }

            System.out.println(cnt);
        }
    }
}