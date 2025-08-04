import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int count = 0;

        for (long i = 5; T / i >= 1; i *= 5)
            count += T / i;

        System.out.println(count);
    }
}
