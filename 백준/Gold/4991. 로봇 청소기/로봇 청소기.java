import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int w, h, MIN;
    static char[][] mapArr;
    static int[] originalStartPos;
    static int[] startPos;
    static List<int[]> dirtyPosList;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int[] arr;
    static int[] sel;
    static boolean[] v;
    
    static int[][] dist;
    
    static boolean isCant;
    
    public static void main(String[] args) throws IOException
    {
    	while(true)
    	{
    		st = new StringTokenizer(br.readLine());
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		
    		if(w == 0 && h == 0)
    			break;
    		
    		mapArr = new char[h][w];
    		startPos = new int[1];
    		dirtyPosList = new ArrayList<>();
    		MIN = Integer.MAX_VALUE;
    		originalStartPos = new int[1];
    		
    		for(int i = 0; i < h; i++)
    		{
    			String str = br.readLine();
    			for(int j = 0; j < str.length(); j++)
    			{
    				mapArr[i][j] = str.charAt(j);
    				if(mapArr[i][j] == 'o')
    					startPos = new int[] {i, j};
    				if(mapArr[i][j] == '*')
    					dirtyPosList.add(new int[] {i, j});
    			}
    		}
    		
    		originalStartPos = startPos;
    		
    		arr = new int[dirtyPosList.size()];
    		for(int i = 0; i < arr.length; i++)
    			arr[i] = i;
    		sel = new int[dirtyPosList.size()];
    		v = new boolean[dirtyPosList.size()];
    		
    		isCant = false;
    		
    		dist = new int[dirtyPosList.size() + 1][dirtyPosList.size() + 1];
    		
    		for(int i = 0; i < dirtyPosList.size(); i++)
    		{
    		    dist[0][i + 1] = bfs(startPos, dirtyPosList.get(i));
    		    if(dist[0][i + 1] == -1)
    		    {
    		        isCant = true;
    		        break;
    		    }
    		}
    		
    		// bfs 거리 미리 저장해놓기
    		for(int i = 0; i < dirtyPosList.size(); i++)
    		{
    			for(int j = 0; j < dirtyPosList.size(); j++)
    			{
    				if(i != j)
    					dist[i + 1][j + 1] = bfs(dirtyPosList.get(i), dirtyPosList.get(j));
    			}
    		}
    		
    		Recursive(0);
    		
    		if(isCant)
    			sb.append(-1).append("\n");
    		else
    			sb.append(MIN).append("\n");
    	}
    	
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    }

	private static int bfs(int[] from, int[] to) 
	{
		Queue<int[]> bfsQ = new ArrayDeque<>();
		boolean[][] checkArr = new boolean[h][w];
		checkArr[from[0]][from[1]] = true;
		bfsQ.offer(new int[] {from[0], from[1], 0});
		
		while(!bfsQ.isEmpty())
		{
			int[] cur = bfsQ.poll();
			
			if(cur[0] == to[0] && cur[1] == to[1])
				return cur[2];
			
			for(int i = 0; i < dx.length; i++)
			{
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < h && ny < w && !checkArr[nx][ny] && mapArr[nx][ny] != 'x')
				{
					checkArr[nx][ny] = true;
					bfsQ.offer(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}
		
		return -1;
	}

	private static void Recursive(int idx) 
	{
		// b
		if(idx == arr.length)
		{
			int sum = 0;
			int current = 0;
			
			// 현위치에서 sel에 i번째꺼 먹으러가기
			for(int i = 0; i < sel.length; i++)
			{
				if(dist[current][sel[i]] == -1)
				{
					isCant = true;
					return;
				}
				sum += dist[current][sel[i] + 1];
				current = sel[i] + 1;
				
				if(sum >= MIN)return;
			}
			
			MIN = Math.min(MIN, sum);
			
			return;
		}
		
		// i
		for(int i = 0; i < arr.length; i++)
		{
			if(!v[i])
			{
				v[i] = true;
				sel[idx] = i;
				Recursive(idx + 1);
				v[i] = false;
			}
		}
	}
}