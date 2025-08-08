import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];
        int[] sel = new int[M];

        for(int i = 0; i < N; i++)
            numArr[i] = i + 1;

        recursive(numArr, sel,0, 0, N, M, sb);

        System.out.println(sb);
    }

    private static void recursive(int[] numArr, int[] sel, int idx, int k, int N, int M, StringBuilder sb)
    {
        // bases part
        if(idx == M)
        {
            for(int i = 0; i < M; i++)
                sb.append(sel[i]).append(" ");
            sb.append("\n");
            return;
        }

        // inductive part
        else
        {
            for(int i = k; i < N; i++)
            {
                sel[idx] = numArr[i];
                recursive(numArr, sel, idx + 1, i, N, M, sb);
            }
        }
    }
}
