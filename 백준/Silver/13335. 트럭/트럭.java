import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, W, L;
    
    static Queue<Integer> waitDeq;
    static List<int[]> bridgeList; // 0 : 인덱스, 1 : 무게, 2 : 다리 시간
    
    static int time, bridgeW, turn;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	W = Integer.parseInt(st.nextToken());
    	L = Integer.parseInt(st.nextToken());
    	
    	waitDeq = new ArrayDeque<>();
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		waitDeq.offer(Integer.parseInt(st.nextToken()));
    	
    	bridgeList = new ArrayList<>();
    	
    	time = 1;
    	bridgeW = 0;
    	turn = 0;
    	
    	while(true)
    	{
    		// 건너기
    		List<Integer> removeList = new ArrayList<>();
    		for(int i = 0; i < bridgeList.size(); i++)
    		{
    			bridgeList.get(i)[2]++;
    			if(bridgeList.get(i)[2] > W)
    				removeList.add(bridgeList.get(i)[0]);
    		}
    		
    		// 나갈거 있음
    		if(removeList.size() > 0)
    		{
    			for(int i = 0; i < removeList.size(); i++)
    			{
    				for(int j = 0; j < bridgeList.size(); j++)
    				{
    					if(removeList.get(i) == bridgeList.get(j)[0])
    					{
    						bridgeW -= bridgeList.get(j)[1];
    						bridgeList.remove(j);
    						break;
    					}
    				}
    			}
    		}
    		
    		if(waitDeq.size() == 0 && bridgeList.size() == 0)
    			break;
    		
    		// 차 채우기
    		if(!waitDeq.isEmpty() && bridgeW + waitDeq.peek() <= L)
			{
				int w = waitDeq.poll();
				bridgeList.add(new int[] {turn, w, 1});
				bridgeW += w;
				turn++;
			}
 
    		time++;
    	}
    	
    	System.out.println(time);
    }
}