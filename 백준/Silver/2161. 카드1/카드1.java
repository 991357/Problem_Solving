import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    static int N;

    public static void main(String[] args) throws IOException 
    {
    	N = Integer.parseInt(br.readLine());
    	
    	Deque<Integer> cardDeq = new ArrayDeque<>();
    	for (int i = 1; i <= N; i++)
			cardDeq.offer(i);
    	
    	while(cardDeq.size() != 1)
    	{
    		// 카드 한 장 빼기
    		sb.append(cardDeq.poll()).append(" ");
    		
    		// 제일 위에꺼 아래로
    		int temp = cardDeq.poll();
    		
    		cardDeq.offer(temp);
    	}
    	sb.append(cardDeq.poll());
    	System.out.println(sb);
    }    
}