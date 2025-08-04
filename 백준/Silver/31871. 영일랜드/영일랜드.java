import java.io.*;
import java.util.*;

public class Main
{
    static long max = -1;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] landArr = new long[N + 1][N + 1];
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long time = Long.parseLong(st.nextToken());

            landArr[x][y] = Math.max(landArr[x][y], time);
        }

        for (int i = 1; i <= N; i++)
        {
            if (landArr[0][i] != 0)
            {
                boolean[] visited = new boolean[N + 1];
                visited[i] = true;
                recursive(landArr, visited, i, landArr[0][i], 1, N);
            }
        }

        System.out.println(max);
    }

    private static void recursive(long[][] landArr, boolean[] visited, int current, long total, int count, int N)
    {
        if (count == N)
        {
            if (landArr[current][0] != 0)
                max = Math.max(max, total + landArr[current][0]);

            return;
        }

        for (int i = 1; i <= N; i++)
        {
            if (!visited[i] && landArr[current][i] != 0)
            {
                visited[i] = true;
                recursive(landArr, visited, i, total + landArr[current][i], count + 1, N);
                visited[i] = false;
            }
        }
    }
}
