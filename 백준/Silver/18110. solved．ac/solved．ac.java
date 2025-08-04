import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> numList = new LinkedList<>();
        for (int i = 0; i < N; i++)
            numList.add(Integer.parseInt(br.readLine()));

        Collections.sort(numList);

        int deleteCount = (int)Math.round(N * 0.15);

        for (int i = 0; i < deleteCount; i++) 
        {
            numList.removeLast();
            numList.removeFirst();
        }

        int sum = 0;
        for (int n : numList)
            sum += n;

        System.out.println(Math.round((double)sum / numList.size()));
    }
}
