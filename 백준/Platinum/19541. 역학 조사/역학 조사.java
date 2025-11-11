import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static List<Integer>[] infectionList;
    static int[] finalState;
    
    public static void main(String[] args) throws IOException 
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        infectionList = new List[M];
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            infectionList[i] = new ArrayList<>();
            for(int j = 0; j < n; j++)
                infectionList[i].add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        finalState = new int[N+1];
        for(int i = 1; i <= N; i++)
            finalState[i] = Integer.parseInt(st.nextToken());
        
        int[] initialState = finalState.clone();
        
        for(int i = M-1; i >= 0; i--)
        {
            List<Integer> members = infectionList[i];
            
            boolean hasZero = false;
            boolean hasOne = false;
            
            for(int member : members)
            {
                if(initialState[member] == 0)
                    hasZero = true;
                else
                    hasOne = true;
            }
            
            if(hasZero && hasOne)
            {
                for(int member : members)
                    initialState[member] = 0;
            }
        }
        
        int[] simulated = initialState.clone();
        
        for(int i = 0; i < M; i++)
        {
            boolean hasInfected = false;
            
            for(int member : infectionList[i])
            {
                if(simulated[member] == 1)
                {
                    hasInfected = true;
                    break;
                }
            }
            
            if(hasInfected)
            {
                for(int member : infectionList[i])
                    simulated[member] = 1;
            }
        }
        
        boolean isValid = true;
        
        for(int i = 1; i <= N; i++)
        {
            if(simulated[i] != finalState[i])
            {
                isValid = false;
                break;
            }
        }
        
        if(!isValid)
            sb.append("NO");
        else
        {
            sb.append("YES\n");
            
            for(int i = 1; i <= N; i++)
                sb.append(initialState[i]).append(" ");
            
            if(sb.length() > 0)
                sb.setLength(sb.length() - 1);
        }
        
        System.out.println(sb);
    }
}