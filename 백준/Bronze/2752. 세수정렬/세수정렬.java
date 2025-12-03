import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception
    {
        int[] arr = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(Integer n : arr)
            sb.append(n).append(" ");

        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
}