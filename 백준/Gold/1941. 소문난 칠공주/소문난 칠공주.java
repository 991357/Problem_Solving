import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map = new char[5][5];
    static boolean[] selected = new boolean[25];
    static int result = 0;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException 
    {
        for(int i = 0; i < 5; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < 5; j++)
                map[i][j] = str.charAt(j);
        }
        
        combination(0, 0);
        
        System.out.println(result);
    }
    
    private static void combination(int start, int count)
    {
        if(count == 7)
        {
            if(isValid())
                result++;
            return;
        }
        
        for(int i = start; i < 25; i++)
        {
            selected[i] = true;
            combination(i + 1, count + 1);
            selected[i] = false;
        }
    }
    
    private static boolean isValid()
    {
        int sCnt = 0;
        List<int[]> positions = new ArrayList<>();
        
        for(int i = 0; i < 25; i++)
        {
            if(selected[i])
            {
                int x = i / 5;
                int y = i % 5;
                positions.add(new int[]{x, y});
                
                if(map[x][y] == 'S')
                    sCnt++;
            }
        }
        
        if(sCnt < 4)
            return false;
        
        return isConnected(positions);
    }
    
    private static boolean isConnected(List<int[]> positions)
    {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        
        int[] start = positions.get(0);
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int count = 1;
        
        while(!queue.isEmpty())
        {
            int[] cur = queue.poll();
            
            for(int i = 0; i < 4; i++)
            {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visited[nx][ny])
                {
                    if(selected[nx * 5 + ny])
                    {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }
        
        return count == 7;
    }
}