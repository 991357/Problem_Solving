import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startNum = Integer.parseInt(st.nextToken()); 
        int lastNum = Integer.parseInt(st.nextToken());  

        ArrayList<Integer> sequence = new ArrayList<>();
        int count = 1;

        while (sequence.size() < lastNum) {
            for (int i = 0; i < count; i++) {
                sequence.add(count);
                if (sequence.size() == lastNum) break;
            }
            count++;
        }

        int sum = 0;
        for (int i = startNum - 1; i < lastNum; i++) {
            sum += sequence.get(i);
        }

        System.out.println(sum);
    }
}
