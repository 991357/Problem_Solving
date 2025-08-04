import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) 
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int x4, y4;

        if (x[0] == x[1]) x4 = x[2];
        else if (x[0] == x[2]) x4 = x[1];
        else x4 = x[0];

        if (y[0] == y[1]) y4 = y[2];
        else if (y[0] == y[2]) y4 = y[1];
        else y4 = y[0];

        System.out.println(x4 + " " + y4);
    }
}
