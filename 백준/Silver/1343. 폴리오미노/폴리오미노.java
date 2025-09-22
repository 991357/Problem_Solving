import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String str;

    public static void main(String[] args) throws IOException
    {
        str = br.readLine();

        boolean isGet = false;

        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'X')
            {
                // 여기부터 4개 혹은 2개
                boolean isFour = true;
                for (int j = i; j < i + 4; j++)
                {
                    if(j >= str.length())
                    {
                        isFour = false;
                        break;
                    }

                    if(str.charAt(j) != 'X')
                    {
                        isFour = false;
                        break;
                    }
                }

                if(isFour)
                {
                    sb.append("AAAA");
                    isGet = true;
                    i += 3;
                }
                else
                {
                    boolean isTwo = true;
                    for (int j = i; j < i + 2; j++)
                    {
                        if(j >= str.length())
                        {
                            isTwo = false;
                            break;
                        }
                        if(str.charAt(j) != 'X')
                        {
                            isTwo = false;
                            break;
                        }
                    }

                    if(isTwo)
                    {
                        sb.append("BB");
                        isGet = true;
                        i += 1;
                    }
                }
            }
            else if(str.charAt(i) == '.')
                sb.append(".");
        }

        if(sb.length() != str.length())
            System.out.println(-1);
        else if(!isGet)
        {
            boolean isDot = true;
            for (int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) != '.')
                {
                    isDot = false;
                    break;
                }
            }
            if(isDot)
                System.out.println(sb);
            else
            {
                sb.append(-1);
            }
        }
        else
            System.out.println(sb);
    }
}