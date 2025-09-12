import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class Edge implements Comparable<Edge>
    {
    	int s, e, w;

		public Edge(int s, int e, int w) 
		{
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) 
		{
			return Integer.compare(this.w, o.w);
		}
    }
    
    static int M, N, total, res; // M : 정점, N : 간선
    static int[] parentArr;
    static Edge[] edgeArr;
    
    public static void main(String[] args) throws IOException
    {
    	while(true)
    	{
        	st = new StringTokenizer(br.readLine());
        	
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	
        	if(M == 0 && N == 0)
        		break;
        	
        	res = 0;
        	total = 0;
        	
        	edgeArr = new Edge[N];
        	for (int i = 0; i < N; i++) 
        	{
        		st = new StringTokenizer(br.readLine());
        		
        		int s = Integer.parseInt(st.nextToken());
        		int e = Integer.parseInt(st.nextToken());
        		int w = Integer.parseInt(st.nextToken());
        		
        		total += w;
        		
        		edgeArr[i] = new Edge(s,e,w);
    		}
        	
        	// makeSet
        	parentArr = new int[M];
        	for (int i = 0; i < M; i++)
    			parentArr[i] = i;
        	
        	Arrays.sort(edgeArr);
        	
        	for(Edge e : edgeArr)
        	{
        		if(find(e.s) != find(e.e))
        		{
        			union(e.s, e.e);
        			res += e.w;
        		}
        	}
        	
        	sb.append(total - res).append("\n");
    	}
    	
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
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