import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strArr[] = new String[3];

        for (int i = 0; i < 3; i ++)
            strArr[i] = br.readLine();

        int plusNum = 0, number = 0;

        for (int i = 2; i >= 0; i--)
        {
            if(strArr[i].equals("Fizz") || strArr[i].equals("Buzz") || strArr[i].equals("FizzBuzz"))
                plusNum++;
            else
            {
                number = Integer.parseInt(strArr[i]) + plusNum + 1;
                break;
            }
        }

        if(number % 3 ==0 && number % 5 == 0)
            System.out.println("FizzBuzz");
        else if(number % 3 == 0)
            System.out.println("Fizz");
        else if(number % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);

    }
}
