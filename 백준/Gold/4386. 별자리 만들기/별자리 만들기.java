import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class Star
	{
		int num;
		double x, y;

		public Star(int num, double x, double y) 
		{
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class StarEdge implements Comparable<StarEdge>
	{
		int s, e;
		double w;

		public StarEdge(int s, int e, double w) 
		{
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(StarEdge o) 
		{
			return Double.compare(this.w, o.w);
		}
	}
	
	static Star[] starArr;
	static int N;
	static int[] parentArr;
	static StarEdge[] edgeArr;
	static double res;
	
    public static void main(String[] args) throws IOException 
    {
    	N = Integer.parseInt(br.readLine());
    	res = 0;
    	
    	starArr = new Star[N];
    	
    	for (int i = 0; i < N; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		double x = Double.parseDouble(st.nextToken());
    		double y = Double.parseDouble(st.nextToken());
    		
    		starArr[i] = new Star(i + 1, x, y);
		}
    	
    	// 만들 수 있는 모든 간선 만들어보기
    	int E = ((N-1) * N) / 2;
    	edgeArr = new StarEdge[E];
    	int turn = 0;
    	
    	for (int i = 0; i < N; i++) 
    	{
    		for (int j = i + 1; j < N; j++) 
    		{
    			int s = starArr[i].num;
    			int e = starArr[j].num;
    			double xW = Math.pow(Math.abs(starArr[i].x - starArr[j].x), 2);
    			double yW = Math.pow(Math.abs(starArr[i].y - starArr[j].y), 2);
    			double w = Math.sqrt(xW + yW);
    			
    			edgeArr[turn] = new StarEdge(s, e, w);
    			turn++;
			}
		}
    	
    	// makeSet
    	parentArr = new int[N+1];
    	for (int i = 1; i <= N; i++) 
    		parentArr[i] = i;
    	
    	Arrays.sort(edgeArr);
    	
    	for(StarEdge se : edgeArr)
    	{
    		if(find(se.s) != find(se.e))
    		{
    			union(se.s, se.e);
    			res += se.w;
    		}
    	}
    	
    	System.out.printf("%.2f", res);
    }
    
    static int find(int a)
    {
    	if(a == parentArr[a]) return a;
    	
    	return parentArr[a] = find(parentArr[a]);
    }
    
    static void union(int a, int  b)
    {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	
    	parentArr[bRoot] = aRoot;
    }
    
}