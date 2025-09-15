import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, E;
    static int node1, node2;
    
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
    static final int INF = 123456789;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	edgeArr = new List[N + 1];
    	for (int i = 1; i <= N; i++)
    		edgeArr[i] = new ArrayList<>();
    	
    	for (int i = 0; i < E; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		
    		edgeArr[s].add(new Edge(e, w));
    		edgeArr[e].add(new Edge(s, w));
		}
    	
    	st = new StringTokenizer(br.readLine());
    	node1 = Integer.parseInt(st.nextToken());
    	node2 = Integer.parseInt(st.nextToken());
    	
    	int path1 = INF, path2 = INF;
    	
    	// 1 -> node1 -> node2 -> N
    	int res1 = dijkstra(1, node1);
    	int res2 = dijkstra(node1, node2);
    	int res3 = dijkstra(node2, N);
    	
    	if(res1 != -1 && res2 != -1 && res3 != -1)
    		path1 = res1 + res2 + res3;
    	
    	// 1 -> node2 -> node1 -> N
    	int res4 = dijkstra(1, node2);
    	int res5 = dijkstra(node2, node1);
    	int res6 = dijkstra(node1, N);
    	
    	if(res4 != -1 && res5 != -1 && res6 != -1)
    		path2 = res4 + res5 + res6;
    	
    	int res = Math.min(path1, path2);
    	
    	System.out.println(res == INF ? -1 : res);
    }
    
    
    static int dijkstra(int start, int end)
    {
    	PriorityQueue<int[]> dstQ = new PriorityQueue<>( (e1, e2) -> {return Integer.compare(e1[1], e2[1]);});
    	int[] costArr = new int[N+1];
    	Arrays.fill(costArr, INF);
    	dstQ.offer(new int[] {start, 0});
    	costArr[start] = 0;
    	
    	while(!dstQ.isEmpty())
    	{
    		int[] cur = dstQ.poll();
    		int n = cur[0];
    		int d = cur[1];
    		
    		if(d > costArr[n]) continue;
    		
    		if(n == end)
    			return d;
    		
    		for (int i = 0; i < edgeArr[n].size(); i++) 
    		{
    			int nd = d + edgeArr[n].get(i).w;
    			
    			if(nd < costArr[edgeArr[n].get(i).e])
    			{
    				costArr[edgeArr[n].get(i).e] = nd;
    				dstQ.offer(new int[] {edgeArr[n].get(i).e, nd});
    			}
			}
    	}
    	return -1;
    }
}