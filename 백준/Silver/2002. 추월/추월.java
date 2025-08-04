import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<String> enterQueue = new LinkedList<>();
        
        for (int i = 0; i < N; i++)
            enterQueue.offer(br.readLine());

        String[] exitArr = new String[N];
        
        for (int i = 0; i < N; i++)
            exitArr[i] = br.readLine();

        int passCarCount = 0;

        for (String outCar : exitArr) {
            if (enterQueue.peek().equals(outCar)) 
                enterQueue.poll();
            else 
            {
                passCarCount++;
                enterQueue.remove(outCar);
            }
        }

        System.out.println(passCarCount);
    }
}
