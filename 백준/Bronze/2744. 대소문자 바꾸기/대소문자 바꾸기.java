import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException 
    {
    	String str = "";
    	
    	str = br.readLine();
    	
    	for(int i = 0; i < str.length(); i++)
    	{
    		if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
    			sb.append((char)(str.charAt(i) - ('a' - 'A')));
    		else
    			sb.append((char)(str.charAt(i) + ('a' - 'A')));
    	}
    	
    	System.out.println(sb);
    }
}