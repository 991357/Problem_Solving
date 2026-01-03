import java.io.*;
import java.util.*;

class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        long answer = 0;
        
        for (int i = 1; i <= N; i++) {
            int j = i;
            while (j > 0) {
                j /= 10;
                answer *= 10;
            }
            answer += i;
            answer %= K;
        }
        
        System.out.println(answer);
    }
}