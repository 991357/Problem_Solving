import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static String S, T;
    static StringBuilder sb = new StringBuilder();
    static int res, cnt;

    public static void main(String[] args) throws IOException 
    {
    	S = br.readLine();
    	T = br.readLine();
    	cnt = 0;
    	
    	for(int i = 0; i < T.length(); i++)
    		sb.append(T.charAt(i));
    	
    	while(true)
    	{
    		if(S.equals(sb.toString()))
    		{
    			res = 1;
    			break;
    		}
    		
    		if(cnt >= T.length())
    			break;
    		
    		if(sb.charAt(sb.length() - 1) == 'A')
    		{
    			sb.setLength(sb.length() - 1);
    			cnt++;
    			continue;
    		}
  
    		if(sb.charAt(sb.length() - 1) == 'B')
    		{
    			sb.setLength(sb.length() - 1);
    			sb.reverse();
    			cnt++;
    			continue;
    		}
    	}
    	
    	System.out.println(res);
    }    
}