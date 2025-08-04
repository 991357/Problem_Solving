import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(num == 0)
            {
                if(minHeap.size() == 0)
                    sb.append(0).append("\n");
                else
                {
                    sb.append(minHeap.peek()).append("\n");
                    minHeap.poll();
                }
            }
            else
                minHeap.add(num);
        }
        System.out.println(sb);
    }
}
