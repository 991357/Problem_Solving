import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, X, maxDist;
	static int[][] mapArr;

    public static void main(String[] args) throws IOException 
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	X = Integer.parseInt(st.nextToken());
    	maxDist = 0;
    	
    	// 맵 만들기
    	mapArr = new int[N+1][N+1];
    	
    	// 갈 수 있는 길 담기
    	for (int i = 0; i < M; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		int d = Integer.parseInt(st.nextToken());
    		
    		mapArr[x][y] = d;
		}
    	
    	for (int i = 1; i <= N; i++) 
    	{
    		if(i != X)
    			maxDist = Math.max(maxDist, dijkstra(i, X) + dijkstra(X, i));
		}
    	System.out.println(maxDist);
    }
    
    private static int dijkstra(int idx, int target) 
    {
    	// 0에 이제 갈 곳, 1에 지금까지 온 거리
    	PriorityQueue<int[]> dstQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
    			return Integer.compare(o1[1], o2[1]);
			}
    	});
    	
    	int[] costArr = new int[N+1];
		Arrays.fill(costArr, Integer.MAX_VALUE);
		
		dstQ.offer(new int[] {idx, 0}); // [1] 에 지금까지 거리 들어있음
    	
    	while(!dstQ.isEmpty())
    	{
    		int[] cur = dstQ.poll();
    		int curIdx = cur[0];
    		int totalDist = cur[1];
    		
    		if(costArr[curIdx] < totalDist)
    			continue;
    		
    		if(curIdx == target)
    			return totalDist;
    		
    		for (int i = 1; i <= N; i++) 
    		{
    			if(mapArr[curIdx][i] != 0)
    			{
    				int nd = totalDist + mapArr[curIdx][i];
    				
    				if(nd < costArr[i])
    				{
    					costArr[i] = nd;
    					dstQ.offer(new int[] {i, nd});
    				}
    			}
			}
    	}
    	return costArr[target] == Integer.MAX_VALUE ? -1 : costArr[target];
	}
}
