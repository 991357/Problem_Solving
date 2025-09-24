import java.io.*;
import java.util.*;
 
public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class Pos
    {
    	int s, e;
    	
    	public Pos(int s, int e)
    	{
    		this.s = s;
    		this.e = e;
    	}
    }
    
    static class Edge
    {
    	int s, e;
    	double w;

		public Edge(int s, int e, double w) 
		{
			this.s = s;
			this.e = e;
			this.w = w;
		}
    }
    
    static Pos[] posArr;
    static List<Edge> edgeList;
    static int N, M;
    static int[] parentArr;
    
    public static void main(String[] args) throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	posArr = new Pos[N];
    	for (int i = 0; i < N; i++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		
    		posArr[i] = new Pos(s,e);
		}
    	
    	// pos i 에서 갈 수 있는 모든 곳이 간선이 됨
    	edgeList = new ArrayList<>();
    	for(int i = 0; i < N; i++)
    	{
    		for(int j = i+1; j < N; j++)
    		{
    			int sr = posArr[i].s;
    			int sc = posArr[i].e;
    			int er = posArr[j].s;
    			int ec = posArr[j].e;
    			double w = Math.sqrt(Math.pow(sr - er, 2) + Math.pow(sc - ec, 2));
    			edgeList.add(new Edge(i, j, w));
    		}
    	}
    	
    	Collections.sort(edgeList, (e1, e2) -> {return Double.compare(e1.w, e2.w);});
    	
     	// makeSet
    	parentArr = new int[N];
    	for(int i = 0; i < N; i++)
    		parentArr[i] = i;
    	
    	// 이미 연결된것
    	for(int i = 0; i < M; i++)
    	{
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken()) - 1;
    		int e = Integer.parseInt(st.nextToken()) - 1;
    		
    		if(find(s) != find(e))
    			union(s, e);
    	}
    	
    	double res = 0;
    	for(Edge e : edgeList)
    	{
    		if(find(e.s) != find(e.e))
    		{
    			union(e.s, e.e);
    			res += e.w;
    		}
    	}
    	System.out.printf("%.2f", res);
    }
    
    static int find(int a)
    {
    	if(parentArr[a] == a) return a;
    	
    	return parentArr[a] = find(parentArr[a]);
    }
    
    static void union(int a, int b)
    {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	
    	parentArr[bRoot] = aRoot;
    }
}