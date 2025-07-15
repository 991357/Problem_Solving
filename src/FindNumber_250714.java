import java.io.*;
import java.util.*;

public class FindNumber_250714
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> nList = new HashSet<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nList.add(Integer.parseInt(st1.nextToken()));

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++)
        {
            if(nList.contains(Integer.parseInt(st2.nextToken())))
                sb.append(1 + "\n");
            else
                sb.append(0+ "\n");
        }

        System.out.println(sb);
    }
}
