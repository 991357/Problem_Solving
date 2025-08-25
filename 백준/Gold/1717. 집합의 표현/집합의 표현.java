import java.io.*;
import java.util.*;

public class Main
{	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M;
	static int[] numArr;

	public static void main(String[] args) throws IOException
	{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numArr = new int[N + 1]; 
		makeSet();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(type == 1) // 둘이 이어져있는지 확인해야함
			{
				findSet(a,b);
			}
			else
			{
				union(a,b);
			}
		}
		if(sb.length() > 0)
			sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static void makeSet()
	{
		for (int i = 0; i <= N; i++) 
			numArr[i] = i;
	}
	
	static int find(int a)
	{
		if(numArr[a] == a) return a;
		
		return numArr[a] = find(numArr[a]);
	}
	
	static void union(int a, int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			return;
		
		numArr[bRoot] = aRoot;
	}
	
	static void findSet(int a, int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)
			sb.append("YES").append("\n");
		else
			sb.append("NO").append("\n");
	}
}

