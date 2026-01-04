import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static int X, Y, N, sum;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[] startPos;
    static List<int[]> posList;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	X = Integer.parseInt(st.nextToken());
    	Y = Integer.parseInt(st.nextToken());
    	
    	N = Integer.parseInt(br.readLine());
    
    	sum = 0;
    	
    	posList = new ArrayList<>();
    	
    	int[][] mapArr = new int[Y+1][X+1];
    	
    	for(int i = 0; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int dir = Integer.parseInt(st.nextToken());
    		int dist = Integer.parseInt(st.nextToken());
    		
    		switch (dir) {
			case 1: // 북
				if(i == N)
					startPos = new int[] {0, dist};
				else
					posList.add(new int[] {0, dist});
				break;
			case 2: // 남
				if(i == N)
					startPos = new int[] {Y, dist};
				else
					posList.add(new int[] {Y, dist});
				break;
			case 3: // 서
				if(i == N)
					startPos = new int[] {dist, 0};
				else
					posList.add(new int[] {dist, 0});
				break;
			case 4: // 동
				if(i == N)
					startPos = new int[] {dist, X};
				else
					posList.add(new int[] {dist, X});
				break;
			}
    	}
    	
    	for(int i = 0; i < posList.size(); i++)
    		sum += bfs(posList.get(i), mapArr);
    	
    	System.out.println(sum);
    }
    
    static int bfs(int[] destination, int[][] mapArr) 
    {
    	Deque<int[]> bfsQ = new ArrayDeque<>();
    	boolean[][] checkArr = new boolean[Y + 1][X + 1];
    	checkArr[startPos[0]][startPos[1]] = true;
    	bfsQ.offer(new int[] {startPos[0], startPos[1], 0});
    	
    	while(!bfsQ.isEmpty())
    	{
    		int[] cur = bfsQ.poll();
    		
    		if(cur[0] == destination[0] && cur[1] == destination[1])
    			return cur[2];
    		
    		for(int i = 0; i < 4; i++) 
    		{
    			int nx = cur[0] + dx[i];
    			int ny = cur[1] + dy[i];
    			
    			if(nx >= 0 && ny >= 0 && nx <= Y && ny <= X && !checkArr[nx][ny]) 
    			{
    				if(nx == 0 || nx == Y || ny == 0 || ny == X) 
    				{
    					checkArr[nx][ny] = true;
    					bfsQ.offer(new int[] {nx, ny, cur[2] + 1});
    				}
    			}
    		}
    	}
    	
    	return -1;
    }
}