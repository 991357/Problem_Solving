import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception 
    {
    	String str = br.readLine();
    	
    	for(int i = 0; i < str.length(); i += 10) {
    		StringBuilder temp = new StringBuilder();
    		for(int j = i; j < i + 10; j++) {
    			
    			if(j == str.length())
    				break;
    			temp.append(str.charAt(j));
    		}
    		temp.append("\n");
    		
    		sb.append(temp);
    	}
    	
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    }
}
