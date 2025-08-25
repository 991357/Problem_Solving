import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N, M;
    static int[] parentsArr;

    public static void main(String[] args) throws Exception
    {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parentsArr = new int[N + 1];

            // makeSet
            for (int i = 1; i <= N; i++)
                parentsArr[i] = i;

            for (int i = 0; i < M; i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> checkSet = new HashSet<>();
            for (int i = 1; i <= N; i++)
                checkSet.add(find(i));

            sb.append("#").append(t).append(" ").append(checkSet.size()).append("\n");
        }
        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    static int find(int a)
    {
        if(parentsArr[a] == a) return a;

        return parentsArr[a] = find(parentsArr[a]);
    }

    static void union(int a, int b)
    {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot)
            return;

        parentsArr[bRoot] = aRoot;
    }
}