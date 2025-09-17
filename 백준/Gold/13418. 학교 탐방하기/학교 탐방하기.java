import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class Edge
    {
    	int s, e, w;

		public Edge(int s, int e, int w) 
		{
			this.s = s;
			this.e = e;
			this.w = w;
		}
    }
    
    static int N, M;
    static Edge[] edgeArr;
    static int[] parentArr;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	edgeArr = new Edge[M + 1];
    	for (int i = 0; i <= M; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int r = Integer.parseInt(st.nextToken());
    		
    		edgeArr[i] = new Edge(s, e, r);
    	}
    	
    	parentArr = new int[N + 1];
    	
    	// makeSet
    	for (int i = 0; i <= N; i++)
    		parentArr[i] = i;
    	
    	Arrays.sort(edgeArr, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) 
			{
				return Integer.compare(o1.w, o2.w);
			}
    	});
    	
    	int res1Cnt = 0;
    	for(Edge e : edgeArr)
    	{
    		if(find(e.s) != find(e.e))
    		{
    			union(e.s, e.e);
    			
    			if(e.w == 0)
    				res1Cnt++;
    		}
    	}
    	
       	// makeSet
    	for (int i = 0; i <= N; i++)
    		parentArr[i] = i;
    	
    	Arrays.sort(edgeArr, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) 
			{
				return Integer.compare(o1.w, o2.w) * -1;
			}
    	});
      	
    	int res2Cnt = 0;
    	for(Edge e : edgeArr)
    	{
    		if(find(e.s) != find(e.e))
    		{
    			union(e.s, e.e);
    			
    			if(e.w == 0)
    				res2Cnt++;
    		}
    	}
    	
    	System.out.println(Math.abs((long)Math.pow(res1Cnt, 2) - (long)Math.pow(res2Cnt, 2)));
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