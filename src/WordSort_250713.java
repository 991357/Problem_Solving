import java.io.*;
import java.util.*;

public class WordSort_250713
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<String> strList = new ArrayList<>();

        for (int i = 0; i < T; i++)
        {
            String temp = br.readLine();
            if(!strList.contains(temp))
                strList.add(temp);
        }

        Collections.sort(strList);

        for (int i = 0; i < strList.size() - 1; i++)
        {
            for (int j = 0; j < strList.size() - i - 1; j++)
            {
                if (strList.get(j).length() > strList.get(j+1).length())
                {
                    String temp = strList.get(j);
                    strList.set(j, strList.get(j+1));
                    strList.set(j+1, temp);
                }
            }
        }

        for (String s : strList)
            System.out.println(s);
    }
}
