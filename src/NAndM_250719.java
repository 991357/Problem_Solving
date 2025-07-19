import java.io.*;
import java.util.*;

public class NAndM_250719
{
    static int N, M;
    static boolean checkArr[];
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checkArr = new boolean[N];
        backTracking(0, "");
    }

    static void backTracking(int depth, String result)
    {
        if(depth == M)
        {
            System.out.println(result);
            return;
        }
        else
        {
            for (int i = 0; i < N; i++)
            {
                if(!checkArr[i])
                {
                    checkArr[i] = true;
                    backTracking(depth + 1, result + (i+1) + " ");
                    checkArr[i] = false;
                }
            }
        }
    }
}
