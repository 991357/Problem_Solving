import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static PriorityQueue<Integer> numQ;
    static int max, min, sum;
    static int ArithmeticAvg, median, mode, range;
    static int[] freq = new int[8001];

    public static void main(String[] args) throws Exception
    {
        N = Integer.parseInt(br.readLine());
        numQ = new PriorityQueue<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        sum = 0;

        for (int i = 0; i < N; i++)
        {
            int n = Integer.parseInt(br.readLine());
            numQ.offer(n);
            max = Math.max(n, max);
            min = Math.min(n, min);
            sum += n;
            freq[n + 4000]++; 
        }

        ArithmeticAvg = (int) Math.round((double) sum / N);

        range = max - min;

        int medianIndex = N / 2;
        int turn = 0;
        while (!numQ.isEmpty())
        {
            int cur = numQ.poll();
            if (turn == medianIndex)
            {
                median = cur;
                break;
            }
            turn++;
        }

        int maxFreq = 0;
        for (int i = 0; i <= 8000; i++)
            if (freq[i] > maxFreq) maxFreq = freq[i];

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        boolean firstFound = false;
        for (int i = 0; i <= 8000; i++)
        {
            if (freq[i] == maxFreq)
            {
                if (!firstFound)
                {
                    first = i - 4000;
                    firstFound = true;
                }
                else
                {
                    second = i - 4000;
                    break;
                }
            }
        }

        mode = (second != Integer.MIN_VALUE) ? second : first;

        sb.append(ArithmeticAvg).append("\n").append(median).append("\n").append(mode).append("\n").append(range);

        System.out.println(sb);
    }
}
