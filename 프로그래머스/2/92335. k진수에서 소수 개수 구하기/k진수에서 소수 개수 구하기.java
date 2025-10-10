class Solution 
{
    static int count = 0;
    
    public int solution(int n, int k) 
    {
        String number = toBaseK(n, k);
        
        // 양옆
        CheckSide(number);
        
        // 오른쪽에만 0
        CheckRight(number);
        
        // 왼쪽에만 0
        CheckLeft(number);
        
        // 얘 자체가?
        CheckSelf(number);
        
        return count;
    }
    
    private static void CheckSelf(String number)
    {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') return;
        }

        if (number.length() > 0) {
            long tempNum = Long.parseLong(number);
            if(isPrime(tempNum))
                count++;
        }
    }
    
    private static void CheckLeft(String number)
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i = number.length() - 1; i >= 0; i--)
        {
            if(number.charAt(i) != '0')
                sb.append(number.charAt(i));
            else
            {
                if(sb.length() > 0)
                {
                    long tempNum = Long.parseLong(sb.reverse().toString()); // 뒤집어서 원래 순서 복원
                    if(isPrime(tempNum))
                        count++;
                }
                break;
            }
        }
    }
    
    private static void CheckRight(String number)
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length(); i++)
        {
            if(number.charAt(i) != '0')
                sb.append(number.charAt(i));
            else
            {
                if(sb.length() > 0)
                {
                    long tempNum = Long.parseLong(sb.toString());
                    if(isPrime(tempNum))
                        count++;
                }
                break;
            }
        }
    }
    
    private static void CheckSide(String number)
    {
        for(int i = 0; i < number.length(); i++)
        {
            if(number.charAt(i) == '0')
            {
                StringBuilder sb = new StringBuilder();
                
                for(int j = i + 1; j < number.length(); j++)
                {
                    if(number.charAt(j) != '0')
                        sb.append(number.charAt(j));
                    else
                    {
                        if(sb.length() > 0)
                        {
                            long tempNum = Long.parseLong(sb.toString());
                            if(isPrime(tempNum))
                                count++;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private static boolean isPrime(long num)
    {
        if(num <= 1) return false;
        
        for (long i = 2; i * i <= num; i++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    
    private static String toBaseK(int n, int k) 
    {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n > 0) 
        {
            int digit = n % k;
            if (digit < 10) sb.append(digit);
            else sb.append((char) ('a' + digit - 10));
            n /= k;
        }
        return sb.reverse().toString();
    }
}
