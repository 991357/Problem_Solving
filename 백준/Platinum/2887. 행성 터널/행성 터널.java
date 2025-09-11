import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class Tunnel
    {
        int num, x, y, z;
        public Tunnel(int num, int x, int y, int z) 
        {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static class TunnelEdge implements Comparable<TunnelEdge>
    {
        int s, e, w;
        public TunnelEdge(int s, int e, int w) 
        {
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public int compareTo(TunnelEdge o) 
        {
            return Integer.compare(this.w, o.w);
        }
    }
    
    static int N, res;
    static Tunnel[] tunnelArr;
    static int[] parentArr;
    
    static ArrayList<TunnelEdge> edgeList;
    
    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        res = 0;
        
        tunnelArr = new Tunnel[N];
        parentArr = new int[N];
        edgeList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) 
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            tunnelArr[i] = new Tunnel(i, x, y, z);
            parentArr[i] = i; // make set
        }
        
        // X좌표 기준
        Arrays.sort(tunnelArr, new Comparator<Tunnel>() {
			@Override
			public int compare(Tunnel o1, Tunnel o2) 
			{
				return Integer.compare(o1.x, o2.x);
			}
		});
        for (int i = 0; i < N - 1; i++)
        {
            int cost = Math.abs(tunnelArr[i].x - tunnelArr[i + 1].x);
            edgeList.add(new TunnelEdge(tunnelArr[i].num, tunnelArr[i + 1].num, cost));
        }
        
        // Y좌표 기준
        Arrays.sort(tunnelArr, new Comparator<Tunnel>() {
			@Override
			public int compare(Tunnel o1, Tunnel o2) 
			{
				return Integer.compare(o1.y, o2.y);
			}
		});
        for (int i = 0; i < N - 1; i++)
        {
            int cost = Math.abs(tunnelArr[i].y - tunnelArr[i + 1].y);
            edgeList.add(new TunnelEdge(tunnelArr[i].num, tunnelArr[i + 1].num, cost));
        }
        
        // Z좌표 기준
        Arrays.sort(tunnelArr, new Comparator<Tunnel>() {
			@Override
			public int compare(Tunnel o1, Tunnel o2) 
			{
				return Integer.compare(o1.z, o2.z);
			}
		});
        for (int i = 0; i < N - 1; i++)
        {
            int cost = Math.abs(tunnelArr[i].z - tunnelArr[i + 1].z);
            edgeList.add(new TunnelEdge(tunnelArr[i].num, tunnelArr[i + 1].num, cost));
        }
        
        Collections.sort(edgeList);
        
        for (TunnelEdge te : edgeList)
        {
            if (find(te.s) != find(te.e))
            {
                union(te.s, te.e);
                res += te.w;
            }
        }
        
        System.out.println(res);
    }
    
    static int find(int a)
    {
        if (a == parentArr[a]) return a;
        
        return parentArr[a] = find(parentArr[a]);
    }
    
    static void union(int a, int b)
    {
        int aRoot = find(a);
        int bRoot = find(b);
        
        parentArr[bRoot] = aRoot;
    }
}