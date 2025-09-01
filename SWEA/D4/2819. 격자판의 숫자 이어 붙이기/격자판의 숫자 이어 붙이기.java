import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int T, N;
	static int[][] numArr;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Set<String> numSet;
	
	public static void main(String[] args) throws IOException 
	{
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) 
		{
			N = 4;
			numArr = new int[N][N];
			numSet = new HashSet<>();
			
			for (int i = 0; i < N; i++) 
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) 
					numArr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 임의의 점에서 시작
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < N; j++) 
					dfs(i, j, "");
			}
			
			sb.append("#").append(t).append(" ").append(numSet.size()).append("\n");
		}
		
		if(sb.length() > 0)
			sb.setLength(sb.length() - 1);
		
		System.out.println(sb);
	}

	private static void dfs(int x, int y, String number)
	{
		if(number.length() == 7)
		{
			//System.out.println(number);
			numSet.add(number);
			return;
		}
		
		for (int i = 0; i < dx.length; i++) 
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N)
			{
				dfs(nx, ny, number + numArr[nx][ny]);
			}
		}
	}
}