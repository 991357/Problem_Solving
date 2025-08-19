import java.io.*;
import java.util.*;

public class Main 
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, cleaningCount;
	static int [][] mapArr; // -1 -> 청소 완료한 칸, 0 -> 청소 안된 칸, 1 -> 벽
	
	static int dx[] = {-1, 0, 1, 0}; // 0 = 북, 1 = 동, 2 = 남, 3 = 서
	static int dy[] = {0, 1, 0, -1};
	
	static Vacuum vacuum;
	static int[] vacuumPos;
	
	public static class Vacuum
	{
		int x, y, d;
		
		Vacuum(int x, int y, int d)
		{
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		public int[] getVacuumPos()
		{
			return new int[]{x,y};
		}
		
		public void setVacuumPos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void changeVacuumDirection()
		{
			this.d -= 1;
			
			if(this.d < 0) // 북쪽에서 반시계 90도 회전하면 서쪽 보기
				this.d = 3;
		}
	}

	public static void main(String[] args) throws IOException 
	{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cleaningCount = 0;
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		vacuum = new Vacuum(x, y, d); // 청소기 생성
		
		mapArr = new int[N][M];
		
		for (int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) 
				mapArr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean isVacuumStop = false;
		
		while(!isVacuumStop)
		{
			// 현재 칸을 청소 함
			vacuumPos = vacuum.getVacuumPos();
			
			if(mapArr[vacuumPos[0]][vacuumPos[1]] == 0) // 아직 청소 안했다.
			{
				mapArr[vacuumPos[0]][vacuumPos[1]] = -1;
				cleaningCount++;
			}
			
			// 청소 할 수 있는 빈 칸 찾기 !
			if(exploreArea())
			{
				// 내 주변에 청소 안된 칸이 있다.
				vacuum.changeVacuumDirection(); // 청소기 반시계 90도로 회전
				
				int nx = vacuum.x + dx[vacuum.d];
				int ny = vacuum.y + dy[vacuum.d];
				
				// 청소기 전진 체크
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && mapArr[nx][ny] == 0)
					vacuum.setVacuumPos(nx, ny);
			}
			else
			{
				// 바라 보는 방향을 유지한채로 뒤로 한칸 후진
				int goalD = 0;
				
				vacuumPos = vacuum.getVacuumPos();
				
				switch(vacuum.d)
				{
				case 0: // 북쪽을 보고 있다면 남쪽으로 후진
					goalD = 2;
					break;
				case 1:
					goalD = 3;
					break;
				case 2:
					goalD = 0;
					break;
				case 3:
					goalD = 1;
					break;
				}
				
				// 후진할곳이 벽이거나.. 인덱스 범위를 벗어난다면 
				int nx = vacuumPos[0] + dx[goalD];
				int ny = vacuumPos[1] + dy[goalD];
				
				if(nx < 0 || ny < 0 || nx >= N && ny >= M || mapArr[nx][ny] == 1)
					isVacuumStop = true; // 청소기 작동 중지 명령
				
				// 청소기 후진
				vacuum.setVacuumPos(nx, ny);
			}
			
			//printArr();
			//vacuumPos = vacuum.getVacuumPos();
			//System.out.println("청소기 위치 : " + vacuumPos[0] + " " + vacuumPos[1]);
		}
		
		//printArr();
		System.out.println(cleaningCount);
	}
	
	static boolean exploreArea()
	{
		vacuumPos = vacuum.getVacuumPos();
		
		boolean isFind = false;
		
		for (int i = 0; i < dx.length; i++) 
		{
			int nx = vacuumPos[0] + dx[i];
			int ny = vacuumPos[1] + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M && mapArr[nx][ny] == 0)
			{
				// 너의 4방면 중 청소 안된 칸이 있다.				
				isFind = true;
				break;
			}
		}
		
		return isFind;
	}
	
	static void printArr()
	{
		for (int i = 0; i < mapArr.length; i++) 
		{
			System.out.println(Arrays.toString(mapArr[i]));
			System.out.println();
		}
	}
}

