import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i <= 9; i++)
            PickNumber(i);

        Collections.sort(list);
        System.out.println(N >= list.size() ? -1 : list.get(N));
    }

    static void PickNumber(long num)
    {
        list.add(num);

        for (long i = 0; i < num % 10; i++)
            PickNumber(num * 10 + i);
    }
}