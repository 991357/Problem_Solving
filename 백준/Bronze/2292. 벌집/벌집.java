import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int level = 1;

        int max = 1;

        while (N > max)
        {
            max += 6 * level;
            level++;
        }

        System.out.println(level);
    }
}
