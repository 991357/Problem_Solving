import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        number = checkDigit(number);

        String temp = number;
        String sumTemp = "";
        String compareValue = "";
        int count = 0;

        while(true)
        {
            sumTemp = String.valueOf(temp.charAt(0) - '0' + temp.charAt(1) - '0');
            sumTemp = checkDigit(sumTemp);

            compareValue = "";
            compareValue += temp.charAt(1);
            compareValue += sumTemp.charAt(1);

            count++;

            if(number.equals(compareValue))
                break;

            temp = compareValue;
        }

        System.out.println(count);
    }

    public static String checkDigit(String value)
    {
        if(value.length() == 1)
            value = String.format("0%s", value);

        return value;
    }
}