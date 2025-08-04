import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++)
        {
            StringBuilder sb = new StringBuilder();

            for (int j = N; j > 0; j--)
            {
                if(j > i)
                    sb.append(" ");
                else
                    sb.append("*");
            }

            System.out.println(sb);
        }
    }
}
