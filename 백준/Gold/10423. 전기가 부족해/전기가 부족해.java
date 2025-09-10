import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Edge implements Comparable<Edge>
    {
        int s, e, w;
        boolean isConnect;

        public Edge(int s, int e, int w)
        {
            this.s = s;
            this.e = e;
            this.w = w;
            isConnect = false;
        }

        @Override
        public int compareTo(Edge o)
        {
            return Integer.compare(this.w, o.w);
        }
    }

    static Edge[] edgeArr;
    static int N, M, K, totalPower;
    static int[] parentArr;
    static Deque<Integer> powerQ;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        totalPower = 0;

        // 발전소 담기
        powerQ = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            powerQ.offer(Integer.parseInt(st.nextToken()));

        // make set
        parentArr = new int[N+1];
        for (int i = 1; i <= N; i++)
            parentArr[i] = i;

        int powerRoot = powerQ.poll(); // 첫 번째 발전소를 루트로
        while (!powerQ.isEmpty()) {
            union(powerRoot, powerQ.poll());
        }
        // 발전소
        edgeArr = new Edge[M];
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeArr[i] = new Edge(s,e,w);
        }

        Arrays.sort(edgeArr);

        for(Edge e : edgeArr)
        {
            if(find(e.s) != find(e.e))
            {
                union(e.s, e.e);
                totalPower += e.w;
            }
        }

        System.out.println(totalPower);
    }

    static int find(int a)
    {
        if(a == parentArr[a]) return a;

        return parentArr[a] = find(parentArr[a]);
    }

    static void union(int a, int b)
    {
        int aRoot = find(a);
        int bRoot = find(b);

        parentArr[bRoot] = aRoot;
    }
}
