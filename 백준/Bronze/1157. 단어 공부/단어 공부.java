import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numArr[] = new int[26];

        String str = br.readLine();
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++)
            numArr[str.charAt(i) - 'A']++;

        int max = 0, maxCount = 0, maxIndex = 0;

        for (int i = 0; i < numArr.length; i++)
        {
            if(numArr[i] != 0)
            {
                if(numArr[i] == max)
                    maxCount++;
                else if(numArr[i] > max)
                {
                    max = numArr[i];
                    maxCount = 0;
                    maxIndex = i;
                }
            }
        }

        if(maxCount == 0)
            System.out.println((char)(maxIndex + 'A'));
        else
            System.out.println("?");
    }
}
