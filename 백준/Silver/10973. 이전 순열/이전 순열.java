import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken()); // 입력 수열 받기

        if(prevPermutation(arr)) 
        {
            for (int i = 0; i < N; i++)
                sb.append(arr[i]).append(" ");
            
            System.out.println(sb);
        } 
        else 
            System.out.println(-1);
    }

    static boolean prevPermutation(int[] a) 
    {
        int i = a.length - 1;
        
        // 1. 뒤에서부터 증가하는 지점 찾기
        while(i > 0 && a[i-1] <= a[i]) 
        	i--;
        
        if(i <= 0) 
        	return false; // 이미 가장 작은 순열

        // 2. 뒤에서부터 a[i-1]보다 작은 원소 찾기
        int j = a.length - 1;
        while(a[j] >= a[i-1]) 
        	j--;

        // 3. swap
        swap(a, i-1, j);

        // 4. 뒤집기
        j = a.length - 1;
        while(i < j) 
        {
            swap(a, i, j);
            i++; j--;
        }
        return true;
    }

    static void swap(int[] a, int i, int j) 
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
