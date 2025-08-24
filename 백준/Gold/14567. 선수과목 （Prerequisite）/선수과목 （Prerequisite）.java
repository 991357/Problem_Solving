import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static List<Integer>[] nodeList;
    static int[] inDegreeArr;
    static int[] answerArr;
    static Deque<Integer> bfsQ;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodeList = new List[N + 1];
        for (int i = 1; i <= N; i++)
            nodeList[i] = new ArrayList<>();
        inDegreeArr = new int[N + 1];
        answerArr = new int[N + 1];
        Arrays.fill(answerArr, 1);

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodeList[s].add(e);
            inDegreeArr[e]++;
        }

        // 지금은 1학기, 1학기에는 inDegree가 0인 애들만 수강 가능
        bfsQ = new ArrayDeque<>();
        for (int i = 1; i < inDegreeArr.length; i++)
        {
            if (inDegreeArr[i] == 0)
                bfsQ.offer(i);
        }
        bfs();
        for (int i = 1; i < answerArr.length; i++)
            sb.append(answerArr[i]).append(" ");

        System.out.println(sb);
    }

    private static void bfs()
    {
        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            for (int i = 0; i < nodeList[cur].size(); i++)
            {
                if(--inDegreeArr[nodeList[cur].get(i)] == 0)
                {
                    answerArr[nodeList[cur].get(i)] = 1 + answerArr[cur];
                    bfsQ.offer(nodeList[cur].get(i));
                }
            }
        }
    }
}
