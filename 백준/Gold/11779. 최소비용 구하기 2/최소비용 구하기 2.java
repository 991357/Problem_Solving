import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, count;
	static int startIdx, endIdx;
	static int[] costArr;
	static int[] parentArr;
	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		

		public Edge(int node, int cost) 
		{
			this.node = node;
			this.cost = cost;
		}


		@Override
		public int compareTo(Edge o) 
		{
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static List<Edge>[] edgeArr;
	
    public static void main(String[] args) throws IOException 
    {
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	count = 0;
    	
    	edgeArr = new List[N + 1];
    	for (int i = 1; i <= N; i++)
			edgeArr[i] = new ArrayList<>();
			
		costArr = new int[N + 1];
		Arrays.fill(costArr, Integer.MAX_VALUE);
		parentArr = new int[N + 1];
		Arrays.fill(parentArr, -1); // 부모 배열 초기화
		
    	for (int i = 0; i < M; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		
    		edgeArr[s].add(new Edge(e, w));
		}
    	
    	st = new StringTokenizer(br.readLine());
    	
    	startIdx = Integer.parseInt(st.nextToken());
    	endIdx = Integer.parseInt(st.nextToken());
    	
    	dijkstra();
    	
    	System.out.println(sb);
    }

	private static void dijkstra() 
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		costArr[startIdx] = 0;
		pq.offer(new Edge(startIdx, 0));
		
		while(!pq.isEmpty())
		{
			Edge cur = pq.poll();
			
			if(cur.node == endIdx) // 도착
			{
				sb.append(costArr[cur.node]).append("\n");
				List<Integer> pathList = new ArrayList<>();
				int current = endIdx;
				while(current != -1)
				{
					pathList.add(current);
					current = parentArr[current];
				}
				
				Collections.reverse(pathList);
				
				sb.append(pathList.size()).append("\n");
				
				for (int i = 0; i < pathList.size(); i++) 
					sb.append(pathList.get(i)).append(" ");
				
				return;
			}
			
			for (int i = 0; i < edgeArr[cur.node].size(); i++) 
			{
				Edge next = edgeArr[cur.node].get(i);
				int nextNode = next.node;
				int nextCost = cur.cost + next.cost;
				if(nextCost < costArr[nextNode])
				{
					costArr[nextNode] = nextCost;
					parentArr[nextNode] = cur.node;
					pq.offer(new Edge(nextNode, nextCost));
				}
			}
		}
	}
}