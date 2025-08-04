import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String str = br.readLine();

            if(str.equals("0"))
                break;

            int turn = str.length() - 1;

            Boolean isFine = false;

            for (int i = 0; i < str.length() / 2; i++)
            {
                if(str.charAt(i) != str.charAt(turn))
                {
                    isFine = true;
                    break;
                }
                turn --;
            }
            if(isFine)
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}
