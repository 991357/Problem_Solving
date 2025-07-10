import java.io.*;

public class SugarDelivery_250710
{
    public static void main(String[] arge) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        Boolean isCant = false;

        while (true)
        {
            if(N % 5 != 0)
            {
                N -= 3;
                count++;
            }
            else
            {
                count += N / 5;
                break;
            }

            if (N == 0)
                break;
            else if(N - 3 != 0 && N - 3 < 3 && N % 5 != 0)
            {
                isCant =true;
                break;
            }
        }

        if(isCant)
            System.out.println(-1);
        else
            System.out.println(count);
    }
}
