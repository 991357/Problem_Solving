import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K, MIN;
    static int[] costArr;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        MIN = Integer.MAX_VALUE;
        costArr = new int[100001];

        bfs();
        System.out.println(MIN);
    }

    private static void bfs()
    {
        Deque<Integer> bfsQ = new ArrayDeque<>();
        bfsQ.offer(N);
        costArr[N] = 0;

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            if(cur == K)
            {
                MIN = costArr[cur];
                return;
            }

            // 걷기
            if(cur + 1 <= 100000 && costArr[cur+1] == 0)
            {
                bfsQ.offer(cur + 1);
                costArr[cur+1] = costArr[cur] + 1;
            }

            if(cur - 1 >= 0 && costArr[cur-1] == 0)
            {
                bfsQ.offer(cur - 1);
                costArr[cur-1] = costArr[cur] + 1;
            }

            // 순간이동
            if(cur * 2 <= 100000 && costArr[cur * 2] == 0)
            {
                bfsQ.offer(cur * 2);
                costArr[cur*2] = costArr[cur] + 1;
            }
        }
    }
}