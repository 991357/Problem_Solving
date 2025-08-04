import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numArr[] = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            numArr[i] = Integer.parseInt(br.readLine());
            sum += numArr[i];
        }

        Arrays.sort(numArr);

        StringBuilder sb = new StringBuilder();
        sb.append((int)((double)sum / 5)).append("\n");
        sb.append(numArr[2]);

        System.out.println(sb);
    }
}
