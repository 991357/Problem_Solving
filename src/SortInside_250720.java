import java.io.*;
import java.util.*;

public class SortInside_250720
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
            numList.add(str.charAt(i) - '0');

        numList.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int n : numList)
            sb.append(n);
        System.out.println(sb);
    }
}
