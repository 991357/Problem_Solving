import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++)
        {
            String str = br.readLine();

            if(str.length() > 1)
                sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
            else
                sb.append((str.charAt(0))).append(str.charAt(0)).append("\n");
        }

        System.out.println(sb);
    }
}