import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, R, answer;
    static int[][] dist;
    static int[] itemArr;

    static final int INF = 123456789;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        answer = 0;

        itemArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            itemArr[i] = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
                dist[i][j] = i == j ? 0 : INF;
        }

        for (int i = 0; i < R; i++)
        {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[r][c] = w;
            dist[c][r] = w;
        }

        for (int k = 1; k <= N; k++)
        {
            for (int i = 1; i <= N; i++)
            {
                for (int j = 1; j <= N; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (int i = 1; i <= N; i++)
        {
            int temp = 0;

            for (int j = 1; j < dist[i].length ; j++)
            {
                if(dist[i][j] <= M)
                    temp += itemArr[j];
            }

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}