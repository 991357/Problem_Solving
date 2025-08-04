import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int numArr[] = new int[N];

        StringTokenizer st_1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
        {
            numArr[i] = Integer.parseInt(st_1.nextToken());
            if(numArr[i] < X)
                System.out.print(numArr[i] + " ");
        }
    }
}
