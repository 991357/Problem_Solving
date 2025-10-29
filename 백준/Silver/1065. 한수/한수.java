import java.io.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, cnt;

    public static void main(String[] args) throws IOException 
    {
        N = Integer.parseInt(br.readLine());
        
        cnt = 0;

        for (int num = 1; num <= N; num++) 
        {
            if (isHansu(num)) 
            	cnt++;
        }
        
        System.out.println(cnt);
    }

    public static boolean isHansu(int num) 
    {
        if (num < 10) 
            return true;

        int[] digits = new int[String.valueOf(num).length()];
        
        for (int i = digits.length - 1; i >= 0; i--) 
        {
            digits[i] = num % 10;
            num /= 10;
        }
        
        int diff = digits[1] - digits[0];
        
        for (int i = 1; i < digits.length - 1; i++) 
        {
            if (digits[i + 1] - digits[i] != diff) 
                return false;
        }
        
        return true;
    }
}
