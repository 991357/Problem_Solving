import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, diffMin;
    static int[] tempArr;
    static PriorityQueue<Integer>[] numPq;

    public static void main(String[] args) throws Exception
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numPq = new PriorityQueue[N];
        for (int i = 0; i < N; i++)
            numPq[i] = new PriorityQueue<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                numPq[i].add(Integer.parseInt(st.nextToken()));
        }

        tempArr = new int[N];
        diffMin = Integer.MAX_VALUE;

        // 초기값 설정
        for (int i = 0; i < N; i++)
            tempArr[i] = numPq[i].poll();

        while(true)
        {
            int min = Integer.MAX_VALUE;
            int max = 0;
            int minIdx = 0;

            for (int j = 0; j < N; j++)
            {
                if(tempArr[j] < min)
                {
                    min = tempArr[j];
                    minIdx = j;
                }
                max = Math.max(max, tempArr[j]);
            }

            int diff = max - min;
            diffMin = Math.min(diffMin, diff);

            if(numPq[minIdx].isEmpty())
                break;

            tempArr[minIdx] = numPq[minIdx].poll();
        }

        System.out.println(diffMin);
    }
}