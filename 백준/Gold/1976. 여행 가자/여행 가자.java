import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[] checkArr;
    static int[] parentsArr;
    static int N, M;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        checkArr = new boolean[N + 1];
        parentsArr = new int[N + 1];

        make();
        for (int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                if(i != j && num == 1)
                {
                    union(i , j);
                }
            }
        }
        int[] tripPlanArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tripPlanArr.length; i++)
            tripPlanArr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tripPlanArr.length; i++)
        {
            for (int j = i + 1; j < tripPlanArr.length; j++)
            {
                if (find(tripPlanArr[i]) != find(tripPlanArr[j])) 
                {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    static void make()
    {
        for (int i = 1; i <= N; i++)
            parentsArr[i] = i;
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

        parentsArr[bRoot] = aRoot;
    }
}