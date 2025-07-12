import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double numArr[] = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        double max = Arrays.stream(numArr).max().getAsDouble() , sum = 0;

        for (int i = 0; i < N; i ++)
            sum += numArr[i] / max * 100;

        System.out.println(sum / N);
    }
}
