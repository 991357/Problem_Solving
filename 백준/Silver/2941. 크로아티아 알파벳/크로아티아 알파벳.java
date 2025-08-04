import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == 'c')
            {
                if(i + 1 < str.length())
                {
                    if(str.charAt(i+1) == '=')
                    {
                        i++;
                        if(i == str.length() - 1)
                        {
                            count++;
                            break;
                        }
                    }
                    if(str.charAt(i+1) == '-')
                    {
                        i++;
                        if(i == str.length() - 1)
                        {
                            count++;
                            break;
                        }
                    }
                }
            }
            else if(str.charAt(i) == 'd')
            {
                if(i + 2 < str.length())
                {
                    if(str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=')
                    {
                        i += 2;
                        if(i == str.length() - 1)
                        {
                            count++;
                            break;
                        }
                    }
                }
                if(i + 1 < str.length())
                {
                    if(str.charAt(i+1) == '-')
                    {
                        i++;
                        if(i == str.length() - 1)
                        {
                            count++;
                            break;
                        }
                    }
                }
            }
            else if(str.charAt(i) == 'l' || str.charAt(i) == 'n')
            {
                if(i + 1 < str.length())
                {
                    if(str.charAt(i+1) == 'j')
                    {
                        i++;
                        if(i == str.length() - 1)
                        {
                            count++;
                            break;
                        }
                    }
                }
            }
            else if(str.charAt(i) == 's' || str.charAt(i) == 'z')
            {
                if(i + 1 < str.length())
                {
                    if(str.charAt(i+1) == '=')
                    {
                        i++;
                        if(i == str.length() - 1)
                        {
                            count++;
                            break;
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
