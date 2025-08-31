import java.io.*;
import java.util.*;

public class Gerrymandering
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, MIN;
    static int[] peopleArr;
    static List<Integer>[] areaArr;

    // 부분 집합
    static int[] arr;
    static boolean[] sel;
    static Deque<List<Integer>> areaDeq;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        MIN = Integer.MAX_VALUE;

        peopleArr = new int[N + 1];
        areaArr = new List[N + 1];
        for (int i = 1; i <= N; i++)
            areaArr[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            peopleArr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++)
                areaArr[i].add(Integer.parseInt(st.nextToken()));
        }

        // 부분 집합을 뽑자.
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i + 1;
        sel = new boolean[N];
        areaDeq = new ArrayDeque<>();
        subset(0);

        while (!areaDeq.isEmpty())
        {
            // 구역 1
            List<Integer> first = areaDeq.pollFirst();

            // 구역 2
            List<Integer> second = areaDeq.pollLast();

            // bfs로 서로 이어져있는지 확인
            if (!bfs(first))
                continue;

            if (!bfs(second))
                continue;

            // 둘 다 이어짐 -> 인구수
            int firstPeople = 0, secondPeople = 0;

            for (int i = 0; i < first.size(); i++)
                firstPeople += peopleArr[first.get(i)];
            for (int i = 0; i < second.size(); i++)
                secondPeople += peopleArr[second.get(i)];

            MIN = Math.min(Math.abs(firstPeople - secondPeople), MIN);
        }
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    private static boolean bfs(List<Integer> group)
    {
        Deque<Integer> bfsQ = new ArrayDeque<>();
        boolean[] checkArr = new boolean[N + 1];
        bfsQ.offer(group.get(0));
        checkArr[group.get(0)] = true;

        int cnt = 1;

        while (!bfsQ.isEmpty())
        {
            int cur = bfsQ.poll();

            for (int i = 0; i < areaArr[cur].size(); i++)
            {
                if (!checkArr[areaArr[cur].get(i)] && group.contains(areaArr[cur].get(i)))
                {
                    checkArr[areaArr[cur].get(i)] = true;
                    bfsQ.offer(areaArr[cur].get(i));
                    cnt++;
                }
            }
        }

        if (cnt == group.size())
            return true;
        else
            return false;
    }

    private static void subset(int idx)
    {
        // b
        if (idx == N)
        {
            List<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < sel.length; i++)
            {
                if (sel[i])
                    tempList.add(arr[i]);
            }
            if (tempList.size() != N && tempList.size() != 0)
                areaDeq.add(tempList);
            return;
        }

        // i
        sel[idx] = true;
        subset(idx + 1);

        sel[idx] = false;
        subset(idx + 1);
    }
}