import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception 
    {
        int X = Integer.parseInt(br.readLine());

        int line = 1;
        int sum = 0;

        while (sum + line < X)
        {
            sum += line;
            line++;
        }

        int idx = X - sum - 1;

        int n, d;
        
        if(line % 2 == 1) 
        {
            n = line - idx;
            d = idx + 1;
        } 
        else
        {
            n = idx + 1;
            d = line - idx;
        }

        System.out.println(n + "/" + d);
    }
}
