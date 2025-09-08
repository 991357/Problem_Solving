import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int startIdx, endIdx;
	static List<int[]>[] numArr;
	static int[] costArr;
	
    public static void main(String[] args) throws IOException 
    {
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	
    	numArr = new List[N + 1];
    	
    	for (int i = 1; i <= N; i++)
			numArr[i] = new ArrayList<int[]>();
			
		costArr = new int[N + 1];
		Arrays.fill(costArr, Integer.MAX_VALUE);
    	
    	for (int i = 0; i < M; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		
    		numArr[s].add(new int[]{e,w});
		}
    	
    	st = new StringTokenizer(br.readLine());
    	
    	startIdx = Integer.parseInt(st.nextToken());
    	endIdx = Integer.parseInt(st.nextToken());
    	
    	int result = dijkstra();
    	
    	System.out.println(result == -1 ? 0 : result);
    }

	private static int dijkstra() 
	{
		PriorityQueue<int[]> dstQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) 
			{
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		costArr[startIdx] = 0;
        dstQ.offer(new int[]{startIdx, 0});
		
		while(!dstQ.isEmpty())
		{
			int[] cur = dstQ.poll();
			
			if(cur[1] > costArr[cur[0]])
				continue;
			
			if(cur[0] == endIdx)
				return cur[1];

			for (int i = 0; i < numArr[cur[0]].size(); i++) 
			{
				int nextNode = numArr[cur[0]].get(i)[0];
				int nextCost = cur[1] + numArr[cur[0]].get(i)[1];
				
				if(nextCost < costArr[nextNode])
				{
					costArr[nextNode] = nextCost;
					dstQ.offer(new int[] {nextNode, nextCost});
				}
			}
		}
		
		return -1;
	}
}