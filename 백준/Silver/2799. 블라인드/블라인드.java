import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static String[] blindArr;
    static int[] blindCntArr;
    static boolean[][] checkArr;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	blindCntArr = new int[5];
    	
    	blindArr = new String[(5*N) + 1];
    	for (int i = 0; i < blindArr.length; i++)
			blindArr[i] = br.readLine();
    	
    	checkArr = new boolean[(5*N) + 1][(5*M) + 1];
    	
    	for (int i = 0; i < blindArr.length; i++) 
    	{
    		for (int j = 0; j < blindArr[i].length(); j++) 
    		{
    			if(!checkArr[i][j] && (blindArr[i].charAt(j) == '*' || blindArr[i].charAt(j) == '.')) 
    			{
    				// 체크 대상
    				int type = 0;
    				
    				for (int k = i; k < i + 4; k++) 
    				{
    					if(blindArr[k].charAt(j) == '*')
    						type++;
    					
    					for (int l = j; l < j + 4; l++)
							checkArr[k][l] = true;
					}
    				
    				blindCntArr[type]++;
    			}
			}
		}
    	
    	for (int i = 0; i < blindCntArr.length; i++) {
    		sb.append(blindCntArr[i] + " ");
		}
    	
    	System.out.println(sb);
    }
    
    static void PrintArr() 
    {
    	for (int i = 0; i < blindArr.length; i++) 
    	{
			for (int j = 0; j < blindArr[i].length(); j++)
				System.out.print(blindArr[i].charAt(j));
			
			System.out.println();
		}
    }
}