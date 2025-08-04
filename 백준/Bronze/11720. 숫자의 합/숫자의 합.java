import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        String num = sc.next();
        int sum = 0;

        for (int i = 0; i < num.length(); i++)
        {
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        System.out.println(sum);
    }
}