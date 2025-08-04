import javax.management.ObjectName;
import java.io.*;
import java.util.*;

public class Main
{
    static int count = 0;
    static int N;
    static List<Integer> complexList = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int aptArr[][] = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++)
                aptArr[i][j] = str.charAt(j) - '0';
        }

        boolean check[][] = new boolean[N][N];

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(aptArr[i][j] == 1)
                    bfs(aptArr, check, i, j);
            }
        }

        sb.append(count).append("\n");

        Collections.sort(complexList);

        for(int i = 0 ; i < complexList.size(); i++)
        {
            sb.append(complexList.get(i));

            if(i != complexList.size() - 1)
                sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int[][] aptArr, boolean[][] check, int row, int col)
    {
        int bfsCount = 0;

        check[row][col] = true;
        aptArr[row][col] = 0;

        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[]{row, col});

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        while (!bfsQ.isEmpty())
        {
             int[] pos = bfsQ.poll();
             bfsCount++;
             int x = pos[0];
             int y = pos[1];

             for(int i = 0; i < 4; i++)
             {
                 int nx = x + dx[i];
                 int ny = y + dy[i];

                 if(nx >= 0 && ny >= 0 && nx < N && ny < N && aptArr[nx][ny] == 1 && !check[nx][ny])
                 {
                     check[nx][ny] = true;
                     aptArr[nx][ny] = 0;
                     bfsQ.offer(new int[]{nx, ny});
                 }
             }
        }
        complexList.add(bfsCount);
        count++;
    }
}
