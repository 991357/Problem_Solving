import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>
    {
        int start, end, weight;

        public Edge(int start, int end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o)
        {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, cnt, sum;
    static Edge[] edgeArr;
    static char[] genderArr;
    static int[] parentArr;

    public static void main(String[] args) throws Exception
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        genderArr = new char[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            genderArr[i] = st.nextToken().charAt(0);

        edgeArr = new Edge[M];
        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeArr[i] = new Edge(s, e, w);
        }
        parentArr = new int[N + 1];

        // 정렬
        Arrays.sort(edgeArr);

        // make set
        makeSet();

        // kruskal
        for (int i = 0; i < edgeArr.length; i++)
        {
            Edge e = edgeArr[i];

            if (find(e.start) != find(e.end) && genderArr[e.start] != genderArr[e.end])
            {
                union(e.start, e.end);
                cnt++;
                sum += e.weight;

                if (cnt == N - 1)
                    break;
            }
        }

        if (cnt != N - 1)
            System.out.println(-1);
        else
            System.out.println(sum);
    }

    private static void makeSet()
    {
        for (int i = 1; i <= N; i++)
            parentArr[i] = i;
    }

    private static int find(int a)
    {
        if (parentArr[a] == a) return a; // 이미 내가 정점

        return parentArr[a] = find(parentArr[a]);
    }

    static void union(int a, int b)
    {
        int aRoot = find(a);
        int bRoot = find(b);

        parentArr[aRoot] = bRoot; // 합치기
    }
}
