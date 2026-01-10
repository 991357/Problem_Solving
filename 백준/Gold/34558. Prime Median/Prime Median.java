import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static int T;
    static final int MAX = 1000000;
    static boolean[] isPrime;
    static int[] primeList;  // 소수만 저장
    static int[] primeCount; // 누적 소수 개수
    static int totalPrimes;
    
    public static void main(String[] args) throws IOException
    {
        before();
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) 
        {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int countS = primeCount[s - 1];
            int countE = primeCount[e];
            int cnt = countE - countS;
            
            if(cnt == 0 || cnt % 2 == 0) 
                sb.append(-1).append("\n");
            else {
                int target = countS + cnt / 2 + 1;
                sb.append(primeList[target]).append("\n");
            }
        }
        
        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);
        
        System.out.println(sb);
    }
    
    private static void before() 
    {
        isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i * i <= MAX; i++) 
        {
            if(isPrime[i]) 
            {
                for(int j = i * i; j <= MAX; j += i) 
                    isPrime[j] = false;
            }
        }
        
        int count = 0;
        
        for(int i = 2; i <= MAX; i++)
            if(isPrime[i]) count++;
        
        primeList = new int[count + 1];
        primeCount = new int[MAX + 1];
        
        int idx = 1;
        
        for(int i = 2; i <= MAX; i++) 
        {
            if(isPrime[i]) 
                primeList[idx++] = i;
            
            primeCount[i] = idx - 1;
        }
        
        totalPrimes = count;
    }
}