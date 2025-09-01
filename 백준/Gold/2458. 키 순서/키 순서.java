import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, cnt;
    static List<Integer>[] inDegreeArr;
    static List<Integer>[] outDegreeArr;
    static boolean[] check;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        inDegreeArr = new List[N + 1];
        outDegreeArr = new List[N + 1];
        for (int i = 1; i <= N; i++)
        {
            inDegreeArr[i] = new ArrayList<>();
            outDegreeArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            inDegreeArr[s].add(e);
            outDegreeArr[e].add(s);
        }

        // 1번부터.. 진출이 모두 가능하고, 진입이 모두 가능한지 체크
        for (int i = 1; i <= N; i++)
        {
            check = new boolean[N + 1];

            // 진입 bfs
            InBfs(i);

            // 진출 bfs
            OutBfs(i);

            // 만약에 check 가 모두 true
            boolean isAllTrue = true;
            for (int j = 1; j < check.length; j++)
            {
                if(!check[j])
                {
                    isAllTrue = false;
                    break;
                }
            }

            if(isAllTrue)
                cnt++;
        }

        System.out.println(cnt);
    }

    private static void OutBfs(int idx)
    {
        // outDegree
        Deque<Integer> bfsQ = new ArrayDeque<>();
        check[idx] = true;
        for (int i = 0; i < outDegreeArr[idx].size(); i++)
        {
            if(!check[outDegreeArr[idx].get(i)])
            {
                bfsQ.offer(outDegreeArr[idx].get(i));
                check[outDegreeArr[idx].get(i)] = true;
            }
        }

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            for (int i = 0; i < outDegreeArr[cur].size(); i++)
            {
                if(!check[outDegreeArr[cur].get(i)])
                {
                    bfsQ.offer(outDegreeArr[cur].get(i));
                    check[outDegreeArr[cur].get(i)] = true;
                }
            }
        }
    }

    private static void InBfs(int idx)
    {
        // inDegree
        Deque<Integer> bfsQ = new ArrayDeque<>();
        check[idx] = true;
        for (int i = 0; i < inDegreeArr[idx].size(); i++)
        {
            if(!check[inDegreeArr[idx].get(i)])
            {
                bfsQ.offer(inDegreeArr[idx].get(i));
                check[inDegreeArr[idx].get(i)] = true;
            }
        }

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            for (int i = 0; i < inDegreeArr[cur].size(); i++)
            {
                if( !check[inDegreeArr[cur].get(i)])
                {
                    bfsQ.offer(inDegreeArr[cur].get(i));
                    check[inDegreeArr[cur].get(i)] = true;
                }
            }
        }
    }
}