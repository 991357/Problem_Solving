import java.io.*;
import java.util.*;
 
public class Solution {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Home
    {
    	int x, y;

		public Home(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}
    }
    
    static int T, N, M, MAX;
    static int[][] mapArr;
    static ArrayList<Home> homeList;
    
    public static void main(String[] args) throws IOException
    {
    	T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		MAX = 0;
    		mapArr = new int[N][N];
    		homeList = new ArrayList<>();
    		
    		for (int i = 0; i < N; i++) 
    		{
    			st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < N; j++) 
    			{			
    				mapArr[i][j] = Integer.parseInt(st.nextToken());
    				
    				if(mapArr[i][j] == 1)
    					homeList.add(new Home(i, j));
				}
			}
    		
    		int K = 1;
    		
    		while(true)
    		{
    			for (int i = 0; i < N; i++) 
    			{
    				for (int j = 0; j < N; j++) 
    				{
    					int res = GetResult(i, j, K);
        				MAX = Math.max(MAX, res);
					}
				}
    			
    			if(K > N+1)
    				break;
    			
    			K++;
    		}
    		
    		sb.append("#").append(t).append(" ").append(MAX).append("\n");
		}
    	
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    }

	private static int GetResult(int x, int y, int p) 
	{
		int cnt = 0;
		
		// bfs 초기화
		Deque<int[]> deq = new ArrayDeque<>();
		deq.offer(new int[] {x, y});
		boolean[][] checkArr = new boolean[N][N];
		checkArr[x][y] = true;
	
		while(!deq.isEmpty())
		{
			int[] cur = deq.poll();
			
			int cx = cur[0];
			int cy = cur[1];
	
			
			if(mapArr[cx][cy] == 1) // 방문 지점이 집이다
				cnt++;
			
			for (int i = 0; i < dx.length; i++) 
			{
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !checkArr[nx][ny])
				{
					checkArr[nx][ny] = true;
					
					// 둘 사이의 거리가  p 미만일때만 가능
					int dist = Math.abs(x - nx) + Math.abs(y - ny);
					
					if(dist < p)
						deq.offer(new int[] {nx,ny});
				}
			}
		}
		
		// 운영 비용
		int managePrice = (p * p) + (p-1) * (p-1);
		
		// 수익
		int profit = M * cnt;
		
		// 보안 회사 이익
		int companyProfit = profit - managePrice;
		
		// 손해만 아니면 돼
		return companyProfit >= 0 ? cnt : -1;
	}
}