import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;
	static int[][] rotateArr;
	static int[] numArr;
	
	public static void main(String[] args) throws IOException 
	{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rotateArr = new int[M][2];
		
		for (int i = 0; i < M; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			rotateArr[i][0] = s;
			rotateArr[i][1] = e;
		}
		
		numArr = new int[N + 1];
		for (int i = 1; i <= N; i++) 
			numArr[i] = i;
		
		Rotate();
		
		for (int i = 1; i < numArr.length; i++) 
			System.out.print(numArr[i] + " ");
	}
	
	private static void Rotate() 
	{
		for (int i = 0; i < M; i++) 
		{
			int s = rotateArr[i][0];
			int e = rotateArr[i][1];
			
			// s부터 시작해서 e 돌리기
			int size = Math.abs(s - e);
			int[] tempArr = new int[size + 1];
			
			// s부터 e 담아놓기
			int turn = 0;
			for (int j = s; j <= e; j++) 
			{
				tempArr[turn] = numArr[j];
				turn++;
			}
			
			for (int j = tempArr.length - 1; j >= 0; j--) 
			{
				numArr[s] = tempArr[j];
				s++;
			}
		}
	}

	static void printArr()
	{
		for (int i = 0; i < M; i++) 
			System.out.println(rotateArr[i][0] + " " + rotateArr[i][1]);
		
		System.out.println();
		
		for (int i = 0; i < numArr.length; i++) 
			System.out.print(numArr[i] + " ");
		
		System.out.println();
	}
}
