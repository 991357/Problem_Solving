import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int T, N;
    
    public static void main(String[] args) throws IOException
    {
    	T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) 
    	{
    		N = Integer.parseInt(br.readLine());
    		
    		int[] dp = new int[N + 1];
    		
    		dp[0] = 0;
    		
    		if(N >= 1)
    			dp[1] = 1;
    		

    		for (int i = 2; i <= N; i++) 
    			dp[i] = dp[i-2] + dp[i-1];
    		
    		if(N == 0)
    			sb.append(1).append(" ").append(0).append("\n");
    		else if(N == 1)
    			sb.append(0).append(" ").append(1).append("\n");
    		else
    			sb.append(dp[N-1]).append(" ").append(dp[N]).append("\n");
		}
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    }
}