import java.io.*;
import java.util.*;

class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine()); 

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long A, long B, long C) {
        // b
        if(B == 0) 
            return 1;
        if(B == 1) 
            return A % C;

        // i
        long half = pow(A, B / 2, C);
        half = (half * half) % C;

        if(B % 2 == 1) {
            half = (half * A) % C;
        }

        return half;
    }
}