import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken()), k = Integer.parseInt(st1.nextToken());

        List<Integer> scoreList = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            scoreList.add(Integer.parseInt(st2.nextToken()));

       scoreList.sort(Collections.reverseOrder());

        System.out.println(scoreList.get(k - 1));
    }
}
