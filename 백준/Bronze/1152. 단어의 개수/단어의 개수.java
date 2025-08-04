import java.io.*;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        if (str.isEmpty()) 
            System.out.println(0);
        else 
            System.out.println(str.split(" ").length);
    }
}
