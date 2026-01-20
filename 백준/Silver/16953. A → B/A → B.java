import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static long A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        if(A == B) {
            System.out.println(1);
            return;
        }
        
        long cnt = 0;
        Deque<long[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new long[] {A, 1});
        
        boolean found = false;
        while(!bfsQ.isEmpty()) {
            long[] cur = bfsQ.poll();
            
            if(cur[0] == B) {
                cnt = cur[1];
                found = true;
                break;
            }
            
            // 2 곱하기
            long temp = cur[0] * 2;
            if(temp <= B) {
                bfsQ.offer(new long[] {temp, cur[1] + 1});
            }
            
            // 뒤에 1 넣기
            StringBuilder sTemp = new StringBuilder();
            sTemp.append(cur[0]);
            sTemp.append("1");
            
            long parsedTemp = Long.parseLong(sTemp.toString());
            if(parsedTemp <= B) {
                bfsQ.offer(new long[] {parsedTemp, cur[1] + 1});
            }
        }
        
        System.out.println(found ? cnt : -1);
    }
}