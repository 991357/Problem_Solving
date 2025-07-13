import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Fact_zeroCount_250713
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        BigInteger facNum = BigInteger.ONE;

        for (int i = 2; i <= T; i++)
            facNum = facNum.multiply(BigInteger.valueOf(i));

        int count = 0;

        for (int i = String.valueOf(facNum).length() - 1; i >= 0; i--)
        {
            if(String.valueOf(facNum).charAt(i) != '0')
                break;

            count++;
        }

        System.out.println(count);
    }
}
