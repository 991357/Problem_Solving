import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, goal, dist;
	static int[][] mapArr;
	
	static int[] startPos;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException
	{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		goal = -1;
		dist = 0;
		
		mapArr = new int[N][M];
		
		for (int i = 0; i < N; i++) 
		{
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) 
			{
				mapArr[i][j] = str.charAt(j) - '0';
				if(mapArr[i][j] == 2)
					startPos = new int[] {i, j};
			}
		}
		
		// 시작지점에서 bfs
		bfs();
		String res;
		res = goal == -1 ? "NIE" : "TAK";
		System.out.println(res);
		if(res.equals("TAK"))
			System.out.println(dist);
	}
	
	private static void bfs() 
	{
		Deque<int[]> bfsQ = new ArrayDeque<>();
		boolean[][] checkArr = new boolean[N][M];
		checkArr[startPos[0]][startPos[1]] = true;
		bfsQ.offer(new int[] {startPos[0], startPos[1], 0});
		
		while(!bfsQ.isEmpty())
		{
			int[] cur = bfsQ.poll();
			int x = cur[0];
			int y = cur[1];
			int d = cur[2];
			
			if(mapArr[x][y] >= 3)
			{
				goal = mapArr[x][y];
				dist = d;
				return;
			}
			
			for (int i = 0; i < dx.length; i++) 
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && mapArr[nx][ny] != 1 && !checkArr[nx][ny])
				{
					checkArr[nx][ny] = true;
					bfsQ.offer(new int[] {nx, ny, d + 1});
				}
			}
		}
	}

	static void PrintArr()
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
				System.out.print(mapArr[i][j] + " ");
			System.out.println();
		}
	}
}