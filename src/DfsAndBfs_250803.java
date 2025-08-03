import java.io.*;
import java.util.*;

public class DfsAndBfs_250803
{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] nodeList = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++)
            nodeList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodeList[e].add(s); // 끝 지점에 시작 추가
            nodeList[s].add(e); // 시작 지점에 끝 추가
        }

        for(int i = 0; i < nodeList.length; i++)
        {
            Collections.sort(nodeList[i]);
        }

        boolean check[] = new boolean[N + 1];

        dfs(nodeList, check, V);

        sb.append("\n");
        Arrays.fill(check, false);

        bfs(nodeList, check, V);

        System.out.println(sb);

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
    private static void dfs(List<Integer>[] nodeList, boolean[] check, int nowRow)
    {
        check[nowRow] = true;
        sb.append(nowRow).append(" ");

        for(int i = 0; i < nodeList[nowRow].size(); i++)
        {
            if(!check[nodeList[nowRow].get(i)])
                dfs(nodeList, check, nodeList[nowRow].get(i));
        }
    }

    private static void bfs(List<Integer>[] nodeList, boolean[] check , int nowRow)
    {
        Queue<Integer> bfsQ = new LinkedList<>();
        bfsQ.add(nowRow);
        check[nowRow] = true;

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();
            sb.append(cur).append(" ");

            for(int i = 0; i < nodeList[cur].size(); i++)
            {
                if(!check[nodeList[cur].get(i)])
                {
                    check[nodeList[cur].get(i)] = true;
                    bfsQ.offer(nodeList[cur].get(i));
                }
            }
        }
    }
}

//https://www.acmicpc.net/problem/1260