import java.io.*;
import java.util.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int sel[] = new int[M];

        recursive(arr, sel, 0, 0, M);
        System.out.println(sb);
    }

    private static void recursive(int[] arr, int[] sel, int idx, int k, int M)
    {
        // b
        if (k == M)
        {
            for(int i = 0; i < sel.length; i++)
                sb.append(sel[i]).append(" ");

            sb.append("\n");
            return;
        }
        if (idx == arr.length) return;

        // i
        for(int i = 0; i < arr.length; i++)
        {
            sel[k] = arr[i];
            recursive(arr, sel, idx + 1, k + 1, M);
        }

    }
}