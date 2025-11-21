import java.io.*;
import java.util.*;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer st;
	
	static int N, K, min, lionCnt, start, len;
	static int[] numArr;
	
    public static void main(String[] args) throws Exception 
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	numArr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		numArr[i] = Integer.parseInt(st.nextToken());
    	
    	min = Integer.MAX_VALUE;
    	lionCnt = 0;
    	start = 0;
    	
    	for(int i = 0; i < N; i++)
    	{
    		if(numArr[i] == 1)
    			lionCnt++;
    		
    		while(lionCnt >= K)
    		{
    			min = Math.min(min, i - start + 1);
    			
    			if(numArr[start] == 1)
    				lionCnt--;
    			
    			start++;
    		}
    	}
    	
    	System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
