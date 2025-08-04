import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken()), M = Integer.parseInt(st1.nextToken());
        int numArr[] = new int[N];

        for (int i = 0; i < M; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            for (int j = a-1; j < b; j++)
                numArr[j] = c;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : numArr)
            sb.append(n + " ");

        System.out.println(sb);

    }
}