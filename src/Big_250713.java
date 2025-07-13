import java.io.*;
import java.util.StringTokenizer;

public class Big_250713
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int heightArr[] = new int[T];
        int weightArr[] = new int[T];

        for (int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            heightArr[i] = h;
            weightArr[i] = w;
        }

        int rankArr[] = new int[T];

        for (int i = 0; i < T; i++)
        {
            int rank = 1;

            for (int j = 0; j < T; j++)
            {
                if (i == j) continue;

                if (heightArr[i] < heightArr[j] && weightArr[i] < weightArr[j])
                    rank++;
            }
            rankArr[i] = rank;
        }

        for (int n : rankArr)
            System.out.print(n + " ");
    }

}
