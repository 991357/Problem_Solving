import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;

	static class Edge implements Comparable<Edge>
	{
		int s, e, c;

		public Edge(int s, int e, int c) 
		{
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) 
		{
			return Integer.compare(this.c, o.c);
		}
	}
	
	static long result;
	static int[] parentArr;
	static List<Edge> edgeList;
	
    public static void main(String[] args) throws IOException 
    {
    	N = Integer.parseInt(br.readLine());
    	
    	// make Set
    	parentArr = new int[N];
    	for (int i = 0; i < N; i++)
			parentArr[i] = i;
    	
    	// 간선 입력
    	edgeList = new ArrayList<>();
    	for (int i = 0; i < N; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) 
    		{
    			int c = Integer.parseInt(st.nextToken());
    			
    			if(i < j)
    				edgeList.add(new Edge(i, j, c));
			}
		}
    	
    	Collections.sort(edgeList);
    	
    	for(Edge e : edgeList)
    	{
    		if(find(e.s) != find(e.e))
    		{
    			union(e.s, e.e);
    			result += e.c;
    		}
    	}
    	
    	System.out.println(result);
    }
    
    static int find(int a)
    {
    	if(a == parentArr[a]) return a;
    	
    	return parentArr[a] = find(parentArr[a]);
    }
    
    static void union(int a, int b)
    {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	
    	parentArr[bRoot] = aRoot;
    }
}