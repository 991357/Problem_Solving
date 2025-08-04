import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = B.length() - 1; i >= 0; i--)
            sb.append((A) * (B.charAt(i) - '0')).append("\n");

        sb.append(A * Integer.parseInt(B));

        System.out.println(sb);
    }
}