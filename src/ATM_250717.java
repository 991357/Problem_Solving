import java.io.*;
import java.util.*;

public class ATM_250717
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int timeArr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            timeArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(timeArr);

        int sum = 0, totalSum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < timeArr.length; i++)
        {
            sum += timeArr[i];
            totalSum += sum;
        }
        sb.append(totalSum);
        System.out.println(totalSum);

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
