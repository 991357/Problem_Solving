    import java.io.*;
    import java.util.*;

    public class Main
    {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static StringBuilder sb = new StringBuilder();

        static int N, M;
        static List<Integer>[] nodeList;
        static boolean[] checkArr;
        static int[] inDegreeArr;

        public static void main(String[] args) throws IOException
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            nodeList = new List[N + 1];
            for (int i = 1; i <= N; i++)
                nodeList[i] = new ArrayList<>();
            inDegreeArr = new int[N + 1];
            checkArr = new boolean[N + 1];

            for (int i = 0; i < M; i++)
            {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                nodeList[s].add(e);
                inDegreeArr[e]++;
            }
            for (int i = 1; i < inDegreeArr.length; i++)
            {
                if(inDegreeArr[i] == 0)
                {
                    // bfs
                    bfs(i);
                }
            }
            System.out.println(sb);
        }

        private static void bfs(int start)
        {
            Deque<Integer> bfsQ = new ArrayDeque<>();
            if(!checkArr[start])
            {
                checkArr[start] = true;
                sb.append(start).append(" ");
                bfsQ.offer(start);
            }

            while (!bfsQ.isEmpty())
            {
                int cur = bfsQ.poll();

                for (int i = 0; i < nodeList[cur].size(); i++)
                {
                    if(--inDegreeArr[nodeList[cur].get(i)] <= 0 && !checkArr[nodeList[cur].get(i)])
                    {
                        checkArr[nodeList[cur].get(i)] = true;
                        sb.append(nodeList[cur].get(i)).append(" ");
                        bfsQ.offer(nodeList[cur].get(i));
                    }
                }
            }
        }

    }
