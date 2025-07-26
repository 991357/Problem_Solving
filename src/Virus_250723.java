import java.io.*;
import java.util.*;

public class Virus_250723
{
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 연결 수

        // 그래프 초기화
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        // 연결 정보 입력
        for (int i = 0; i < M; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문 배열
        visited = new boolean[N + 1];

        // 1번 컴퓨터에서 DFS 시작
        visited[1] = true; // 1번은 방문했다고 체크
        dfs(1);

        // 1번 제외한 감염 컴퓨터 수 출력
        System.out.println(count);
    }

    static void dfs(int node)
    {
        for (int next : graph[node])
        {
            if (!visited[next])
            {
                visited[next] = true;
                count++; // 방문할 때마다 감염 컴퓨터 카운트
                dfs(next);
            }
        }
    }
}
