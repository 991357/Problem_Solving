import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException 
    {
        int N = Integer.parseInt(br.readLine());
        int[] info = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++)
            info[i] = Integer.parseInt(st.nextToken());
        
        int[] result = new int[N];
        
        for (int height = 1; height <= N; height++) 
        {
            int count = info[height];
            int emptyCount = 0; 
            
            for (int i = 0; i < N; i++) 
            {
                if (result[i] == 0) 
                {
                    if (emptyCount == count) 
                    {
                        result[i] = height;
                        break;
                    }
                    emptyCount++;
                }
            }
        }
        
        for (int i = 0; i < N; i++)
            sb.append(result[i]).append(" ");
        
        System.out.println(sb);
    }
}