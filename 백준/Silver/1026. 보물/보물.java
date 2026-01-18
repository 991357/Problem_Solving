import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static int N;
    
    public static void main(String[] args) throws IOException
    {
    	N = Integer.parseInt(br.readLine());
    	
    	PriorityQueue<Integer> aPq = new PriorityQueue<>();
    	PriorityQueue<Integer> bPq = new PriorityQueue<>(Collections.reverseOrder());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		aPq.add(Integer.parseInt(st.nextToken()));
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		bPq.add(Integer.parseInt(st.nextToken()));
    	
    	int sum = 0;
    	while(!aPq.isEmpty())
    		sum += aPq.poll() * bPq.poll();
    	
    	System.out.println(sum);
    }
}