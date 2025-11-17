import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int sum;
    
    public static void main(String[] args) throws IOException 
    {
    	for(int i = 0; i < 5; i++)
    		sum += Integer.parseInt(br.readLine());
    	
    	System.out.println(sum);
    }
}