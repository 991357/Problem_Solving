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

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            recursive(N, 0, "1", 1, false);
            
            sb.append("\n");
        }
        
        if(sb.length() > 0)
        	sb.setLength(sb.length() - 1);
        
        System.out.println(sb);
    }

    private static void recursive(int N, int depth, String str, int cur, boolean isNumberTurn) {
        // b
        if(depth == N - 1) {
            int sum = 0;
            int curNum = 0;
            char before = '+';
            
            for(int i = 0; i < str.length(); i++) {
            	if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            		// 얘는 숫자임
            		curNum = curNum * 10 + (str.charAt(i) - '0');
            	} else {
            		if(str.charAt(i) == '+' || str.charAt(i) == '-') {
            			if(before == '+')
            				sum += curNum;
            			else if(before == '-')
            				sum -= curNum;
                		before = str.charAt(i);
                		curNum = 0;
            		}
            	}
            }
            
            // 마지막 숫자
            if(before == '+')
            	sum += curNum;
            else if(before == '-')
            	sum -= curNum;
            
            if(sum == 0)
            	sb.append(str).append("\n");
            
            return;
        }

        // i
        if(isNumberTurn) {
            // 숫자 추가
            cur += 1;
            str += cur;
            recursive(N, depth + 1, str, cur, false);
        } else {
        	recursive(N, depth, str + " ", cur, true);
            recursive(N, depth, str + "+", cur, true);
            recursive(N, depth, str + "-", cur, true);
        }
    }
}