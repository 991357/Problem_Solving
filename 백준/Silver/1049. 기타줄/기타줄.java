import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, M;

    public static void main(String[] args) throws Exception 
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	int minPack = Integer.MAX_VALUE;
    	int minPiece = Integer.MAX_VALUE;

    	for (int i = 0; i < M; i++) {
    	    st = new StringTokenizer(br.readLine());
    	    int pack = Integer.parseInt(st.nextToken());
    	    int piece = Integer.parseInt(st.nextToken());

    	    minPack = Math.min(minPack, pack);
    	    minPiece = Math.min(minPiece, piece);
    	}

    	int min = Math.min(N / 6 * minPack + N % 6 * minPiece, Math.min((N / 6 + 1) * minPack, N * minPiece));
    	
    	System.out.println(min);
    }
}
