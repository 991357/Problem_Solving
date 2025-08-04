import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        List<Integer> primeList = new ArrayList<>();
        
        for(int i = M; i <= N; i++)
        {
        	if(isPrime(i))
        		primeList.add(i);
        }
        
        for(int n : primeList)
        	System.out.println(n);
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
