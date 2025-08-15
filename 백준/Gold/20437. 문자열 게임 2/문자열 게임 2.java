import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int T, K;
    static String W;

    static int MIN;
    static int MAX;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++)
        {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            MIN = Integer.MAX_VALUE;
            MAX = Integer.MIN_VALUE;

            CheckW();

            if(MIN == Integer.MAX_VALUE || MAX == Integer.MIN_VALUE)
               sb.append(-1).append("\n");
            else
                sb.append(MIN).append(" ").append(MAX).append("\n");
        }

        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void CheckW()
    {
        for(int i = 0; i < 27; i++)
        {
            for (int j = 0; j < W.length(); j++)
            {
                if(W.charAt(j) == 97+i)
                {
                    int tempK = 0;
                    boolean isUpdate = false;

                    for (int k = j; k < W.length(); k++)
                    {
                        if(W.charAt(k) == 97+i)
                        {
                            tempK++;
                            if(tempK == K)
                            {
                                tempK = (k - j) + 1;
                                isUpdate = true;
                                break;
                            }
                        }
                    }
                    if(isUpdate)
                    {
                        MIN = Math.min(MIN, tempK);
                        MAX = Math.max(MAX, tempK);
                    }
                }
            }
        }
    }
}
