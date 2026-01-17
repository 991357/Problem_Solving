import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static Set<Integer> numSet;
    static int N;
    
    public static void main(String[] args) throws IOException
    {
    	N = Integer.parseInt(br.readLine());
    	numSet = new TreeSet<>();
    	st= new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		numSet.add(Integer.parseInt(st.nextToken()));
    	
    	for(int n : numSet)
    		sb.append(n).append(" ");
    	
    	if(sb.length()>0)
    		sb.setLength(sb.length()-1);
    	
    	System.out.println(sb);
    }
}