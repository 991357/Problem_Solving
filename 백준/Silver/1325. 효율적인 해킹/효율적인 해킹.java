import java.io.*;
import java.util.*;

public class Main
{
    static int resultArr[];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        resultArr = new int[M];

        List<Integer>[] computerList = new List[N + 1];
        for(int i = 0; i <= N; i++)
            computerList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computerList[b].add(a);
        }

        int resultArr[] = new int[N + 1];

        for(int i = 1; i <= N; i++)
        {
            boolean check[] = new boolean[computerList.length];
            resultArr[i] = bfs(computerList, check, i);
        }

        int max = 0;
        for(int i = 0; i < resultArr.length; i++)
        {
            if(max < resultArr[i])
                max = resultArr[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < resultArr.length; i++)
        {
            if(resultArr[i] == max)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(List<Integer>[] computerList, boolean[] check, int idx)
    {
        Queue<Integer> bfsQ = new LinkedList<>();

        int count = 0;

        check[idx] = true;
        bfsQ.offer(idx);
        count++;

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            for(int i = 0; i < computerList[cur].size(); i++)
            {
                if(!check[computerList[cur].get(i)])
                {
                    check[computerList[cur].get(i)] = true;
                    bfsQ.offer(computerList[cur].get(i));
                    count++;
                }
            }
        }
        return count;
    }
}