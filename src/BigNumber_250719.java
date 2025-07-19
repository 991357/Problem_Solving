import java.io.*;
import java.util.*;

public class BigNumber_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        String N = st1.nextToken();
        int k = Integer.parseInt(st1.nextToken());
        StringBuilder sb = new StringBuilder();

        if(Integer.parseInt(N) <= k)
        {
            sb.append(N);
            System.out.println(sb);
        }
        else
        {
            int kArr[] = new int[k];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++)
                kArr[i] = Integer.parseInt(st.nextToken());

            AddNumber(N, N.length(), sb, kArr);
        }

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }

    public static void AddNumber(String N, int depth, StringBuilder sb, int[] kArr)
    {
        if(N.length() == depth)
        {
            int first = (int)N.charAt(0) - '0';

            int max = 0;
            for (int i = 0; i < kArr.length; i++)
            {
                if(kArr[i] <= first && kArr[i] > max)
                    max = kArr[i];
            }
            if(max != 0)
            {
                sb.append(max);
                AddNumber(N, depth - 1, sb, kArr);
            }
            else
            {
                sb.append(N);
                System.out.println(sb);
            }
        }
        else
        {
            if(depth == 0)
                System.out.println(sb);
            else
            {
                sb.append(Arrays.stream(kArr).max().getAsInt());
                AddNumber(N, depth - 1, sb, kArr);
            }
        }
    }
}
