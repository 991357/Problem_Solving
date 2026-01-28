import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;

    public static void main(String[] args) throws Exception 
    {
    	String line;
    	
    	while((line = br.readLine()) != null) {
    		st = new StringTokenizer(line);
    		
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		int cnt = 0;
    		
    		// N부터 시작
    		for(int i = N; i <= M; i++) {
    			HashSet<Character> tempSet = new HashSet<>();
    			
    			String str = String.valueOf(i);
    			
    			for(int j = 0; j < str.length(); j++)
    				tempSet.add(str.charAt(j));
    			
    			if(str.length() == tempSet.size())
    				cnt++;
    		}
    		
    		sb.append(cnt).append("\n");
    	}

    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    	
    }
}
