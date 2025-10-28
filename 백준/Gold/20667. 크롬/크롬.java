import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, M, K;
    
    static class CPU
    {
    	int useVal, memoryVal, importanceVal;

		public CPU(int useVal, int memoryVal, int importanceVal) 
		{
			this.useVal = useVal;
			this.memoryVal = memoryVal;
			this.importanceVal = importanceVal;
		}
    }
    
    static CPU[] cpuArr;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	cpuArr = new CPU[N + 1];
    	
    	for(int i = 1; i <= N; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		int use = Integer.parseInt(st.nextToken());
    		int memory = Integer.parseInt(st.nextToken());
    		int importance = Integer.parseInt(st.nextToken());
    		
    		cpuArr[i] = new CPU(use, memory, importance);
    	}
    	
    	int[][] dp = new int[M + 1][501];
    	
    	for(int i = 0; i <= M; i++)
    		Arrays.fill(dp[i], Integer.MIN_VALUE);
    	
    	dp[0][0] = 0;
    	
    	for(int i = 1; i <= N; i++)
    	{
    		CPU cpu = cpuArr[i];
    		
    		for(int j = M; j >= 0; j--)
    		{
    			for(int p = 500; p >= 0; p--)
    			{
    				int nextCpu = Math.min(M, j + cpu.useVal);
    				int nextImportance = p + cpu.importanceVal;
    				
    				if(nextImportance <= 500 && dp[j][p] != Integer.MIN_VALUE)
    				{
    					dp[nextCpu][nextImportance] = Math.max(
    						dp[nextCpu][nextImportance],
    						dp[j][p] + cpu.memoryVal
    					);
    				}
    			}
    		}
    	}
    	
    	int answer = -1;
    	
    	for(int i = 0; i <= 500; i++)
    	{
    		if(dp[M][i] >= K)
    		{
    			answer = i;
    			break;
    		}
    	}
    	
    	System.out.println(answer);
    }
}