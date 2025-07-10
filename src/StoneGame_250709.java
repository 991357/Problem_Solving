import java.io.*;

public class StoneGame_250709
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Boolean isSKTurn = false;

        while (N != 0)
        {
            if(isSKTurn)
                isSKTurn = false;
            else
                isSKTurn = true;

            if (N > 3)
                N -= 3;
            else
                N--;

        }
        if(isSKTurn)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
