import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int[] numArr;
	
	public static void main(String[] args) throws IOException 
	{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numArr = new int[N];
		for(int i = 0; i < N; i++)
			numArr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(numArr);
		
		int start = 0;
		int end = 1;
		int min = Integer.MAX_VALUE;
		
		while(end < N)
		{
			int diff = numArr[end] - numArr[start];
			
			if(diff >= M)
			{
				min = Math.min(min, diff);
				start++;
				
				if(start == end)
					end++;
			}
			else 
			{
				end++;
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}