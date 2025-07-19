import java.io.*;
import java.util.*;

public class NumberCard_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> numSet = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            Integer temp = Integer.parseInt(st1.nextToken());
            numSet.add(temp);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++)
        {
            int value = Integer.parseInt(st2.nextToken());

            if(numSet.contains(value))
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }


        System.out.println(sb);

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
