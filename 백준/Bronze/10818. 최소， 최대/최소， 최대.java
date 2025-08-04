import javax.management.StringValueExp;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int numArr[] = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numArr.length; i++)
        {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.stream(numArr).min().getAsInt() + " " + Arrays.stream(numArr).max().getAsInt());
    }
}
