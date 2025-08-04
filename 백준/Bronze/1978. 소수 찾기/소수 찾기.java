import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < count; i++)
        {
            int num =  sc.nextInt();
            list.add(num);
        }

        int sumCount = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if(isPrime(list.get(i)))
            {
                sumCount++;
            }
        }

        System.out.println(sumCount);
    }

    public static Boolean isPrime(int num)
    {
        if (num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if (num % i == 0)
                return false; 
        }

        return true;
    }
}