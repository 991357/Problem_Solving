import java.io.*;
import java.util.*;

public class Main
{
    static int safeArea = 1;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] numList = new List[N + 1];

        for(int i = 0; i <= N; i++)
            numList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            numList[s].add(e);
            numList[e].add(s);
        }
        boolean[] check = new boolean[N + 1];
        int count = 0;

        for(int i = 1; i <= N; i++)
        {
            if(!check[i])
            {
                // 여기있는거 다 가보기
                dfs(numList, check, i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(List<Integer>[] numList, boolean[] check, int idx)
    {
        Stack<Integer> dfsStack = new Stack<>();

        for(int i = 0; i < numList[idx].size(); i++)
        {
            if(!check[numList[idx].get(i)])
                dfsStack.push(numList[idx].get(i));
        }

        while (!dfsStack.isEmpty())
        {
            int n = dfsStack.pop();
            check[n] = true;

            for(int i = 0; i < numList[n].size(); i++)
            {
                if(!check[numList[n].get(i)])
                {
                    check[numList[n].get(i)] = true;
                    dfsStack.push(numList[n].get(i));
                }
            }
        }
    }
}