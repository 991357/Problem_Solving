import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) { System.out.println(0); return; }

        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[S] = 0;
        q.add(S);

        while (!q.isEmpty())
        {
            int cur = q.poll();

            int up = cur + U;
            if (U > 0 && up <= F && dist[up] == -1)
            {
                dist[up] = dist[cur] + 1;
                if (up == G) { System.out.println(dist[up]); return; }
                q.add(up);
            }

            int down = cur - D;
            if (D > 0 && down >= 1 && dist[down] == -1)
            {
                dist[down] = dist[cur] + 1;
                if (down == G) { System.out.println(dist[down]); return; }
                q.add(down);
            }
        }

        System.out.println("use the stairs");
    }
}
