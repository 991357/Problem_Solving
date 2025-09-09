import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;
    static class Edge implements Comparable<Edge>
    {
        int s, e, c;
        public Edge(int s, int e, int c) 
        {
            this.s = s;
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Edge o) 
        {
            return Integer.compare(this.c, o.c);
        }
    }
    
    static int result;
    static int[] parentArr;
    static int[] waterArr;
    static List<Edge> edgeList;
    
    public static void main(String[] args) throws IOException 
    {
        N = Integer.parseInt(br.readLine());
        
        // make Set - 가상노드 0 + 실제노드 1~N = 총 N+1개
        parentArr = new int[N + 1];
        for (int i = 0; i <= N; i++)
            parentArr[i] = i;
            
        waterArr = new int[N];
        for (int i = 0; i < N; i++) 
            waterArr[i] = Integer.parseInt(br.readLine());
      
        edgeList = new ArrayList<>();
        
        // 가상 노드(0)에서 각 지역으로의 우물 비용 간선 추가
        for (int i = 0; i < N; i++) 
            edgeList.add(new Edge(0, i + 1, waterArr[i]));
        
        // 지역 간 연결 비용 간선 추가 - 전체 행렬을 읽되 중복 제거
        for (int i = 0; i < N; i++) 
        {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) 
            {
                int c = Integer.parseInt(st.nextToken());
                
                if (i < j)  // 중복 제거: i < j인 경우만 간선 추가 
                    edgeList.add(new Edge(i + 1, j + 1, c));
            }
        }
        
        Collections.sort(edgeList);
        
        for(Edge e : edgeList)
        {
            if(find(e.s) != find(e.e))
            {
                union(e.s, e.e);
                result += e.c;
            }
        }
        
        System.out.println(result);
    }
    
    static int find(int a)
    {
        if(a == parentArr[a]) return a;
        
        return parentArr[a] = find(parentArr[a]);
    }
    
    static void union(int a, int b)
    {
        int aRoot = find(a);
        int bRoot = find(b);
        
        parentArr[bRoot] = aRoot;
    }
}