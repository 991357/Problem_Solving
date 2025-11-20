import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st;
	
	static int N;
	static long[] arr;
	
    public static void main(String[] args) throws Exception 
    {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        
        int cnt = 0;

        for (int i = 0; i < N; i++) 
        {
            long target = arr[i];
            int start = 0;
            int end = N - 1;

            while (start < end) 
            {
                if (start == i) 
                {
                	start++; 
                	continue;
                }
                if (end == i)
                {
                	end--; 
                	continue;
                }

                long sum = arr[start] + arr[end];

                if (sum == target) 
                {
                	cnt++;
                    break;
                }
                else if (sum < target) 
                    start++;
                else 
                	end--;
            }
        }

        System.out.println(cnt);
    }
}
