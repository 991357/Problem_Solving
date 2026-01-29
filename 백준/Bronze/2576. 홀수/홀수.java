import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> numPq = new PriorityQueue<>();

        int sum = 0;

        for(int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            numPq.offer(n);
            if(n % 2 != 0)
                sum += n;
        }


        while(!numPq.isEmpty()) {
            int n = numPq.poll();

            if(n % 2 != 0) {
                sb.append(sum).append("\n");
                sb.append(n);
                break;
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}