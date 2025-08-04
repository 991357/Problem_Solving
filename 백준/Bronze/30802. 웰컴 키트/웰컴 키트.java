import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(br.readLine());

        int clothBundle = 0;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int sizeArr[] = new int[6];
        for (int i =0; i < 6; i++)
            sizeArr[i] = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < sizeArr.length; i++)
        {
            if(sizeArr[i] != 0)
            {
                if(sizeArr[i] / T < 1)
                    clothBundle++;
                else if(sizeArr[i] % T == 0)
                    clothBundle += sizeArr[i] / T;
                else
                    clothBundle += sizeArr[i] / T + 1;
            }
        }

        System.out.println(clothBundle);

        System.out.println(people / P + " " + people % P);
    }
}
