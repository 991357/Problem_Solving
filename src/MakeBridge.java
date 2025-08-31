import java.io.*;
import java.util.*;

public class MakeBridge
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int V, E, A, B, C, cnt;
    static long sum, ESum;

    static class Edge implements Comparable<Edge>
    {
        int x, y, w;

        public Edge(int x, int y, int w)
        {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o)
        {
            return Integer.compare(this.w, o.w);
        }
    }

    static Edge[] edgeArr;
    static int[] parentArr;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        cnt = 0;
        sum = 0;
        ESum = 0;

        edgeArr = new Edge[E];
        parentArr = new int[V + 1];

        // make set
        make();

        // 간선 입력
        for (int i = 0; i < E; i++)
        {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            ESum += C;

            edgeArr[i] = new Edge(A, B, C);
        }
        // 간선 정렬
        Arrays.sort(edgeArr);

        boolean isEnd = false;

        for (int i = 0; i < edgeArr.length; i++)
        {
            if (find(edgeArr[i].x) != find(edgeArr[i].y))
            {
                union(edgeArr[i].x, edgeArr[i].y);
                cnt++;
                sum += edgeArr[i].w;

                if (cnt == V - 1){
                    isEnd = true;
                    break;
                }
            }
        }

        System.out.println(!isEnd ? -1 : ESum - sum);
    }

    private static void make()
    {
        for (int i = 1; i <= V; i++)
            parentArr[i] = i;
    }

    static int find(int a)
    {
        if (a == parentArr[a]) return a;

        return parentArr[a] = find(parentArr[a]);
    }

    static void union(int a, int b)
    {
        int aRoot = find(a);
        int bRoot = find(b);

        parentArr[bRoot] = aRoot;
    }
}