import java.io.*;
import java.util.*;

public class Main
{	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Deque<Integer> deq = new ArrayDeque<>();
	static int N;

	public static void main(String[] args) throws IOException
	{
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			String type = st.nextToken();
			
			if(type.equals("push_front"))
			{
				int num = Integer.parseInt(st.nextToken());
				deq.offerFirst(num);
			}
			else if(type.equals("push_back"))
			{
				int num = Integer.parseInt(st.nextToken());
				deq.offerLast(num);
			}
			else if(type.equals("pop_front"))
			{
				if(deq.size()!= 0)
					sb.append(deq.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(type.equals("pop_back"))
			{
				if(deq.size()!= 0)
					sb.append(deq.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(type.equals("size"))
			{
				sb.append(deq.size()).append("\n");
			}
			else if(type.equals("empty"))
			{
				if(deq.size() == 0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			else if(type.equals("front"))
			{
				if(deq.size()!= 0)
					sb.append(deq.peekFirst()).append("\n");
				else
					sb.append(-1).append("\n");
			}
			else if(type.equals("back"))
			{
				if(deq.size()!= 0)
					sb.append(deq.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}

