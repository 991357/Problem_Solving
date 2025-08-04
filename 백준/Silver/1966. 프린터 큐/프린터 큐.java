import java.io.*;
import java.util.*;

public class Main
{
	public static class Document
	{
		int index;
		int importance;
		
		Document(int index, int importance)
		{
			this.index = index;
			this.importance = importance;
		}
	}
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 0; test_case < T; test_case++)
        {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st1.nextToken());
        	int turn = Integer.parseInt(st1.nextToken());
        	
        	Queue<Document> docQueue = new LinkedList<Document>();
        	
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	for(int i = 0; i < N; i++)
        	{
        		int temp = Integer.parseInt(st2.nextToken());
        		docQueue.offer(new Document(i, temp));
        	}
        	
        	int count = 0;
        	while(true)
        	{
        		Document temp = docQueue.poll();
        		boolean hasHigher = false;
        		for (Document doc : docQueue) 
        		{
        		    if (doc.importance > temp.importance) 
        		    {
        		        hasHigher = true;
        		        break;
        		    }
        		}
        		if (hasHigher) 
        			docQueue.offer(temp); 
        		else 
        		{
        			count++;
        		    if(temp.index == turn)
        		    {
        		    	System.out.println(count);
        		    	break;
        		    }
        		}
        	}
        }
    }
}
