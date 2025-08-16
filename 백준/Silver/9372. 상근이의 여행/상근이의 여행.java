import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N, M, totalCount, count;
    static List<Integer>[] airplaneList;
    static boolean[] checkArr;
    static boolean isStop = false;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            airplaneList = new List[N];
            for (int i = 0; i < N; i++)
                airplaneList[i] = new ArrayList<>();
            for (int i = 0; i < M; i++)
            {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                airplaneList[s - 1].add(e - 1);
                airplaneList[e - 1].add(s - 1);
            }
            totalCount = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++)
            {
                checkArr = new boolean[N];
                count = 0;
                isStop = false;
                // i 에서 출발 -> 갈 수 있는곳 끝까지 가보기
                Plane(i);
                totalCount = Math.min(totalCount, count);
            }
            sb.append(totalCount).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void Plane(int idx)
    {
        Deque<Integer> bfsQ = new ArrayDeque<>();
        bfsQ.offer(idx);
        checkArr[idx] = true;

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            for (int i = 0; i < airplaneList[cur].size(); i++)
            {
                if(!checkArr[airplaneList[cur].get(i)])
                {
                    checkArr[airplaneList[cur].get(i)] = true;
                    bfsQ.offer(airplaneList[cur].get(i));
                    count++;
                }
            }
        }
    }

    private static boolean CheckAllTrue()
    {
        for (boolean b : checkArr)
        {
            if (!b)
                return false;
        }
        return true;
    }
}
