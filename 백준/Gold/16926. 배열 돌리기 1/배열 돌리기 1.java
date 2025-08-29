import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, R;
	static int[][] numArr;
	
    public static void main(String[] args) throws IOException 
    {
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	
    	numArr = new int[N][M];
    	for (int i = 0; i < N; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < M; j++) 
    			numArr[i][j] = Integer.parseInt(st.nextToken());
		}
    	//printArr(numArr);
    	for (int i = 0; i < R; i++) {
    		RotateArr(numArr);	
		}
    	
    	printArr(numArr);
    }
    
    static void RotateArr(int[][] arr)
    {
    	int[][] newArr = new int[N][M];
        // 원본 가져오기
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            	newArr[i][j] = arr[i][j];
        }
        
        int top = 0, left = 0, bottom = N - 1, right = M - 1;

        while (top < bottom && left < right)
        {
            for (int j = left; j < right; j++)
            	arr[top][j] = newArr[top][j + 1];

            for (int i = top; i < bottom; i++)
            	arr[i][right] = newArr[i + 1][right];

            for (int j = right; j > left; j--)
            	arr[bottom][j] = newArr[bottom][j - 1];

            for (int i = bottom; i > top; i--)
            	arr[i][left] = newArr[i - 1][left];

            top++; left++; bottom--; right--;
        }
    }
    
    static void printArr(int[][] arr)
    {
    	for (int i = 0; i < arr.length; i++) 
    	{
    		for (int j = 0; j < arr[i].length; j++) 
    			System.out.print(arr[i][j] + " ");
    		System.out.println();
		}
    }
}
