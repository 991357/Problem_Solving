import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0, turn = 0;

        for (int i = 0; i < 9; i++)
        {
            int temp = Integer.parseInt(br.readLine());

            if(temp > max)
            {
                max = temp;
                turn = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(turn);
    }
}
