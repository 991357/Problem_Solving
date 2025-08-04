import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int plus = Integer.parseInt(br.readLine());

        M += plus;
        if(M >= 60)
        {
            H += (int)((double)M / 60);
            M = M % 60;
            if(H >= 24)
                H -= 24;
        }

        System.out.println(H + " " + M);
    }
}