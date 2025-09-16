import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, M, K;
    
    static class Edge
    {
    	int e, w;
    	
    	public Edge(int e, int w)
    	{
    		this.e = e;
    		this.w = w;
    	}
    }
    
    static List<Edge>[] edgeArr;
    static long[][] costArr;
    static final long INF = Long.MAX_VALUE;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	edgeArr = new List[N+1];
    	for (int i = 1; i <= N; i++)
    		edgeArr[i] = new ArrayList<>();
    	
    	for (int i = 0; i < M; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		
    		edgeArr[s].add(new Edge(e, w));
    		edgeArr[e].add(new Edge(s, w));
		}
    	
    	costArr = new long[N+1][K+1];
    	for(int i = 1; i <= N; i++)
    		Arrays.fill(costArr[i], INF);
    	
    	dijkstra();
    	
    	long min = Long.MAX_VALUE;
    	
    	for (int i = 0; i < costArr[N].length; i++)
    		min = Math.min(min, costArr[N][i]);
    	
    	System.out.println(min);
    }

	private static void dijkstra() 
	{
		PriorityQueue<long []> dstQ = new PriorityQueue<>((e1, e2) -> {return Long.compare(e1[1], e2[1]);});
		dstQ.offer(new long[] {1, 0, 0});
		costArr[1][0] = 0;
		
		while(!dstQ.isEmpty())
		{
			long[] cur = dstQ.poll();
			long n = cur[0];
			long d = cur[1];
			long pCnt = cur[2];
			
			if(d > costArr[(int)n][(int)pCnt]) continue;
			
			for(Edge e : edgeArr[(int)n])
			{
				int next = e.e;
				int dist = e.w;
				
				long nd = d + dist;
				
				if(nd < costArr[next][(int)pCnt])
				{
					costArr[next][(int)pCnt] = nd;
					dstQ.offer(new long[] {next, nd, pCnt});
				}
				
				if(pCnt < K && d < costArr[next][(int)(pCnt + 1)])
				{
					costArr[next][(int)(pCnt + 1)] = d;
				    dstQ.offer(new long[]{next, d, pCnt + 1});
				}
			}
		}
	}
}