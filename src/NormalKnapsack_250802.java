import java.io.*;
import java.util.*;

public class NormalKnapsack_250802
{
    static int max = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Integer>> packList = new ArrayList<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            List<Integer> addList = new ArrayList<>();

            int weight = Integer.parseInt(st.nextToken());
            int happy = Integer.parseInt(st.nextToken());

            addList.add(weight);
            addList.add(happy);

            packList.add(addList);
        }

        List<Integer> keyTemp = new ArrayList<>();

        for (int i = 0; i < packList.size(); i++)
            keyTemp.add(packList.get(i).get(0));

        boolean sel[] = new boolean[keyTemp.size()];

        recursive(packList, keyTemp, sel, 0, K);

        System.out.println(max);
    }

    private static void recursive(List<List<Integer>> packList, List<Integer> keyTemp, boolean[] sel, int idx, int K)
    {
        // b
        if(idx == keyTemp.size())
        {
            int weightTemp = 0;
            int happyTemp = 0;

            for (int i = 0; i < keyTemp.size(); i++)
            {
                if(sel[i])
                {
                    weightTemp += packList.get(i).get(0);
                    happyTemp += packList.get(i).get(1);
                }
            }

            if(weightTemp <= K)
                max = Math.max(max, happyTemp);

            return;
        }

        // i

        // 선택
        sel[idx] = true;
        recursive(packList, keyTemp, sel, idx + 1, K);

        // 노선택
        sel[idx] = false;
        recursive(packList, keyTemp, sel, idx + 1, K);
    }
}