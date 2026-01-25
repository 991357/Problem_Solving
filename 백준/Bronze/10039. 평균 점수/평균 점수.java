import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception 
    {
    	int sum = 0;
    	
    	for(int i = 0; i < 5; i++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		if(n < 40)
    			n = 40;
    		
    		sum += n;
    	}
    	
    	System.out.println((int)(sum / 5));
    }
}
