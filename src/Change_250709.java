import java.io.*;

public class Change_250709
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        if(price == 1 || price == 3)
        {
            System.out.println(-1);
            return;
        }

        int changeCoinCount = 0;

        while (price % 5 != 0)
        {
            price -=2;
            changeCoinCount++;
        }

        changeCoinCount += price /5;

        System.out.println(changeCoinCount);
    }
}
