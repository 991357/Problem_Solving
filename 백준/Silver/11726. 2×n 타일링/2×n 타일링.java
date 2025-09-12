import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws IOException
    {
    	N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N+1]; // 0 : 1*2 , 1 : 2*1
    	
    	dp[1] = 1;
    	
    	if(N>1)
    		dp[2] = 2;
    	
    	for (int i = 3; i <= N; i++) 
    		dp[i] = (dp[i-2] + dp[i-1]) % 10007;
    	
    	System.out.println(dp[N]);
    }
}