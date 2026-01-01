import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	int day = Integer.parseInt(br.readLine());
        	
        	st = new StringTokenizer(br.readLine());
        	int[] pricesArr = new int[day];
        	
        	for(int i = 0; i < day; i++)
        		pricesArr[i] = Integer.parseInt(st.nextToken());
        	
        	long benefit = 0;
        	int maxPrice = 0;
        	
        	for(int i = day - 1; i >= 0; i--) {
        		if(pricesArr[i] > maxPrice)
        			maxPrice = pricesArr[i];  // 최고가 갱신
        		else
        			benefit += maxPrice - pricesArr[i];  // 사서 최고가에 팔기
        	}
        	
        	sb.append(benefit).append("\n");
        }
        
        if(sb.length() > 0)
        	sb.setLength(sb.length() - 1);
        
        System.out.println(sb);
    }
}