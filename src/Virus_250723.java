import java.io.*;
import java.util.*;

public class Virus_250723
{
    static int count = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int nodeCount = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] computerList = new ArrayList[computerCount+1];

        for(int i = 0; i <= computerCount; i++)
            computerList[i] = new ArrayList<>();

        for(int i = 0; i < nodeCount; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            computerList[s].add(e); // 시작 - 끝
            computerList[e].add(s); // 끝 - 시작
        }

        bfs(computerList, 1);

        System.out.println(count - 1);
    }

    private static void bfs(List<Integer>[] computerList, int idx)
    {
        Queue<Integer> virusQ = new LinkedList<>();
        virusQ.offer(idx);
        boolean check[] = new boolean[computerList.length];
        check[idx] = true;

        while (!virusQ.isEmpty())
        {
            int cur = virusQ.poll();
            count++;

            for(int i = 0; i < computerList[cur].size(); i++)
            {
                if(!check[computerList[cur].get(i)])
                {
                    check[computerList[cur].get(i)] = true;
                    virusQ.offer(computerList[cur].get(i));
                }
            }
        }
    }
}