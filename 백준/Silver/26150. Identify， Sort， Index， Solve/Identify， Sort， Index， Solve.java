import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static int N;
    
    static class Identify{
    	String str;
    	int I, D;
    	
    	public Identify(String str, int I, int D) {
    		this.str = str;
    		this.I = I;
    		this.D = D;
    	}
    }
    
    public static void main(String[] args) throws IOException
    {
    	N = Integer.parseInt(br.readLine());
    	
    	List<Identify> identifyList = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		String str = st.nextToken();
    		int I = Integer.parseInt(st.nextToken());
    		int D = Integer.parseInt(st.nextToken());
    		
    		identifyList.add(new Identify(str, I, D));
    	}
    	
    	Collections.sort(identifyList, new Comparator<Identify>() {
    		@Override
    		public int compare(Identify a, Identify b) {
    			return Integer.compare(a.I, b.I);
    		}
		});
    	
    	for(int i = 0; i < identifyList.size(); i++) {
    		Identify iden = identifyList.get(i);
    		char c = iden.str.charAt(iden.D-1);
    		
    		if(c >= 'a' && c <= 'z')
    		{
    			String s = String.valueOf(c);
    			s = s.toUpperCase();
    			sb.append(s);
    		} else 
    			sb.append(c);
    	}
    	System.out.println(sb);
    }
}