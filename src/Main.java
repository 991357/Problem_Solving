import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int posArr[][] = new int[N][2];

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++)
                posArr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 오름 차순
        Arrays.sort(posArr, (o1, o2) ->
        {
            return o1[0] - o2[0];
        });
        int x = posArr[2][0] - posArr[0][0];

        Arrays.sort(posArr, (o1, o2) ->
        {
            return o1[1] - o2[1];
        });
        int y = posArr[2][1] - posArr[0][1];

        System.out.println(x*y);
    }
}
