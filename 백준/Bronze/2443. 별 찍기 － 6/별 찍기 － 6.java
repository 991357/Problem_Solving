import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int count = N - 1;

        for (int i = N; i > 0; i--)
        {
            for (int j = N; j > 0; j--)
            {
                if(j > i)
                    sb.append(" ");
                else
                    sb.append("*");
            }

            for (int j = 0; j < count; j++)
                sb.append("*");

            sb.append("\n");
            count--;
        }

        System.out.println(sb);
    }
}