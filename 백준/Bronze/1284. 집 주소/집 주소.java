import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        String input;
        while (!(input = br.readLine()).equals("0"))
        {
            int totalWidth = 2;
            
            for (int i = 0; i < input.length(); i++)
            {
                char digit = input.charAt(i);
                
                if (digit == '1')
                    totalWidth += 2;
                else if (digit == '0')
                    totalWidth += 4;
                else
                    totalWidth += 3;
                
                if (i < input.length() - 1)
                    totalWidth += 1;
            }
            
            sb.append(totalWidth).append("\n");
        }
        
        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);
        
        System.out.println(sb);
    }
}