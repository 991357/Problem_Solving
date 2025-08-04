import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 0;

        for (int test_case = 0; test_case < T; test_case++)
        {
            boolean checkArr[] = new boolean[26];

            String str = br.readLine();
            checkArr[str.charAt(0) - 'a'] = true;

            boolean isNot = false;

            for (int i = 1; i < str.length(); i++)
            {
                if (str.charAt(i - 1) != str.charAt(i))
                {
                    if(!checkArr[str.charAt(i) - 'a'])
                        checkArr[str.charAt(i) - 'a'] = true;
                    else
                    {
                        isNot = true;
                        break;
                    }
                }
            }

            if(!isNot)
                count++;
        }
        System.out.println(count);
    }
}
