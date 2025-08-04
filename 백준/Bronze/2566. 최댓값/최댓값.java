import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numArr[][] = new int[9][9];

        int max = 0, xIndex = 0, yIndex = 0;

        for (int i = 0; i < 9; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++)
            {
                numArr[i][j] = Integer.parseInt(st.nextToken());
                if(numArr[i][j] > max)
                {
                    max = numArr[i][j];
                    xIndex = i;
                    yIndex = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        sb.append(xIndex + 1).append(" ").append(yIndex + 1);
        System.out.println(sb);
    }
}
