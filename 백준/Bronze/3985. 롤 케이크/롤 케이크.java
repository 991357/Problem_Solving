import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    
    static int L, N;
    static int expectNum, expectVal, actualNum, actualVal;
    
    public static void main(String[] args) throws IOException
    {
    	L = Integer.parseInt(br.readLine());
    	N = Integer.parseInt(br.readLine());
    	
    	List<int[]> wantList = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		
    		if(expectVal < (end - start)) { // 가장 많은 케이크를 받을것으로 예상되는 사람
    			expectVal = (end - start);
    			expectNum = i + 1;
    		}
    		
    		wantList.add(new int[] {start, end});
    	}
    	
    	boolean[] cakeArr = new boolean[L + 1];
    	
    	for(int i = 0; i < N; i++) {
    		
    		int[] cur = wantList.get(i);
    		int sum = 0;
    		
    		for(int j = cur[0]; j <= cur[1]; j++) {
    			if(!cakeArr[j]) {
    				sum++;
    				cakeArr[j] = true;
    			}
    		}
    		
    		if(sum > actualVal) {
    			actualVal = sum;
    			actualNum = i + 1;
    		}
    	}
    	
    	System.out.println((expectNum == 0 ? 1 : expectNum) + "\n" + (actualNum == 0 ? 1 : actualNum));
    }
}