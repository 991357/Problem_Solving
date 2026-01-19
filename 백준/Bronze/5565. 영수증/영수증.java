import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException
    {
    	int sum = Integer.parseInt(br.readLine());
    	for(int i = 0; i < 9; i++)
    		sum -= Integer.parseInt(br.readLine());
    	System.out.println(sum);
    }
}