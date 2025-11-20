import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++)
        {
            int n, m;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int cnt = 0;

            int[] aArr = new int[n];
            int[] bArr = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                aArr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++)
                bArr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(aArr);
            Arrays.sort(bArr);

            for(int i = 0; i < n; i++)
            {
                if(aArr[i] > bArr[0])
                {
                    for(int j = 0; j < m; j++)
                    {
                        if(aArr[i] > bArr[j])
                            cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
}