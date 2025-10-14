import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int T;

    public static void main(String[] args) throws IOException
    {
    	T = Integer.parseInt(br.readLine());
    	
    	for (int t = 0; t < T; t++) 
    	{
    		String p = br.readLine();
    		String[] pArr = p.split("");
    		
    		int N = Integer.parseInt(br.readLine());
    		ArrayDeque<Integer> numDeq = new ArrayDeque<>();
    		String str = br.readLine();
    		
    		if(N > 0)
    		{
        		for(int i = 1; i < str.length()-1; i++)
        		{
        			StringBuilder tsb = new StringBuilder();
        			while(true)
        			{
        				if(str.charAt(i) == ',' || i == str.length() - 1)
        					break;
        				tsb.append(str.charAt(i));
        				i++;
        			}
        			numDeq.offer(Integer.parseInt(tsb.toString()));
        		}
    		}
    		
    		boolean isReversed = false;
    		boolean isError = false;
    		
    		for(int i = 0; i < pArr.length; i++)
    		{
    			if(pArr[i].equals("R"))
    			{
    				isReversed = !isReversed;
    			}
    			else // D
    			{
    				if(numDeq.size() > 0)
    				{
    					if(isReversed)
    						numDeq.pollLast();
    					else
    						numDeq.pollFirst();
    				}
    				else
    				{
    					isError = true;
    					break;
    				}
    			}
    		}
    		
    		if(isError)
    			sb.append("error").append("\n");
    		else
    		{
    			StringBuilder tsb = new StringBuilder();
    			tsb.append("[");
    			
    			if(numDeq.size() > 0)
    			{
        			if(isReversed)
        			{
        				while(numDeq.size() > 1)
        					tsb.append(numDeq.pollLast()).append(",");
        				tsb.append(numDeq.pollLast());
        			}
        			else
        			{
        				while(numDeq.size() > 1)
        					tsb.append(numDeq.pollFirst()).append(",");
        				tsb.append(numDeq.pollFirst());
        			}
    			}
    			
    			tsb.append("]");
    			sb.append(tsb).append("\n");
    		}
		}
    	
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	System.out.println(sb);
    }
}