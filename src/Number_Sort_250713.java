import java.io.*;
import java.util.*;

public class Number_Sort_250713
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < T; i++)
            numSet.add(Integer.parseInt(br.readLine()));

        ArrayList<Integer> tempList = new ArrayList<>(numSet);

        Collections.sort(tempList);

        StringBuilder sb = new StringBuilder();

        for (int n : tempList)
            sb.append(n + "\n");

        System.out.println(sb);
    }
}
