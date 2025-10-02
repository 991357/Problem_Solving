import java.io.*;

public class Main
{
    static int[] cache = new int[1000001];
    static int cacheSize = 0;
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line;
        while ((line = br.readLine()) != null)
        {
            int N = Integer.parseInt(line.trim());
            if (N == 0) break;
            
            sb.append(findNth(N)).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }

    static int findNth(int n)
    {
        if (n <= cacheSize)
            return cache[n];
        
        int num = (cacheSize == 0) ? 0 : cache[cacheSize];
        
        while (cacheSize < n)
        {
            num++;
            if (hasUniqueDigits(num))
            {
                cacheSize++;
                cache[cacheSize] = num;
            }
        }
        
        return cache[n];
    }

    static boolean hasUniqueDigits(int num)
    {
        int mask = 0;
        
        while (num > 0)
        {
            int digit = num % 10;
            int bit = 1 << digit;
            
            if ((mask & bit) != 0)
                return false;
            
            mask |= bit;
            num /= 10;
        }
        
        return true;
    }
}