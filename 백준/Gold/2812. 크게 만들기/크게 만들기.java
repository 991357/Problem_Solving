import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, K;
    
    public static void main(String[] args) throws IOException 
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        String str = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int removeCount = 0;
        
        for(int i = 0; i < N; i++)
        {
            char current = str.charAt(i);
            
            while(!stack.isEmpty() && stack.peek() < current && removeCount < K)
            {
                stack.pop();
                removeCount++;
            }
            
            stack.push(current);
        }
        
        while(removeCount < K)
        {
            stack.pop();
            removeCount++;
        }
        
        for(char c : stack)
            sb.append(c);
        
        System.out.println(sb);
    }
}