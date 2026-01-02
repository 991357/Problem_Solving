import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static int T;

    public static void main(String[] args) throws IOException
    {
    	T = Integer.parseInt(br.readLine());
    	int[] alphaArr;
    	
    	for(int t = 1; t <= T; t++) {
    		alphaArr = new int[26];
    		
    		String str = br.readLine();
    		str = str.toLowerCase(); // 걍 다 소문자로
    		int min = Integer.MAX_VALUE;
    		
    		for(int i = 0; i < str.length(); i++) {
    			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
    				alphaArr[str.charAt(i) - 'a']++; // 여기 증가
    			}
    		}
    		
    		for(int i = 0; i < alphaArr.length; i++) {
    			min = Math.min(min, alphaArr[i]);
    		}
    		
    		String res = "";
			switch (min) {
			case 0:
			case Integer.MAX_VALUE:
				res = "Not a pangram";
				break;
			case 1:
				res = "Pangram!";
				break;
			case 2:
				res = "Double pangram!!";
				break;
			case 3:
				res = "Triple pangram!!!";
				break;
			}
			sb.append("Case " + t + ": " + res).append("\n");
    	}
    	System.out.println(sb);
    }
}