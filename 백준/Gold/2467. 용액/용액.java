import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, startIdx, endIdx;
    static int[] numArr;
    static int[] answerPos;
    static int minAbs = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(numArr);

        startIdx = 0;
        endIdx = N - 1;
        answerPos = new int[2];

        while (startIdx < endIdx)
        {
            int sum = numArr[startIdx] + numArr[endIdx];
            int absSum = Math.abs(sum);

            if (absSum < minAbs)
            {
                minAbs = absSum;
                answerPos[0] = numArr[startIdx];
                answerPos[1] = numArr[endIdx];
            }

           
            if (sum == 0)
                break;      
            else if (sum < 0)
                startIdx++;
            else
                endIdx--;
        }

        System.out.println(answerPos[0] + " " + answerPos[1]);
    }
}