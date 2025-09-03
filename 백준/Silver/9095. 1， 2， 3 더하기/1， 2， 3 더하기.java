import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int T, N;
	static int[] dp;
	
    public static void main(String[] args) throws IOException 
    {
    	T = Integer.parseInt(br.readLine());
    	
    	for (int t = 0; t < T; t++) 
    	{
    		N = Integer.parseInt(br.readLine());
    		
    		dp = new int[N + 1];
    		
    		dp[1] = 1;
    		
    		if(N >= 2)
    			dp[2] = 2;
    		if(N >= 3)
    			dp[3] = 4;
    		if(N >= 4)
    		{
        		for (int i = 4; i < N + 1; i++) 
        			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    		}
    		sb.append(dp[N]).append("\n");
		}
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    }
}
