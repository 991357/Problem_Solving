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

        long res = 5;
        long next = 7;

        for(int i = 2; i <= N; i++)
        {
            res += next;
            next += 3;
            res %= 45678;
        }

        System.out.println(res);
    }
}