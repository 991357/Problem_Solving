import java.io.*;
import java.util.*;

public class Main
{
    static int safeArea = 1;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int numArr[][] = new int[M][N];

        for(int i = 0; i < M; i++)
        {
            String str = br.readLine();
            String[] temp = str.split(" ");
            for(int j = 0; j < temp.length; j++)
                numArr[i][j] = Integer.parseInt(temp[j]);
        }
        
        boolean checkArr[][] = new boolean[M][N];
        
        if(dfs(numArr, checkArr, N , M))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    private static boolean dfs(int[][] numArr, boolean[][] checkArr, int N, int M)
    {
        Stack<int[]> dfsStack = new Stack<>();

        int dx[] = {1, 0};
        int dy[] = {0, 1};

        // 시작 점 초기화
        dfsStack.push(new int[]{0, 0});
        checkArr[0][0] = true;

        while (!dfsStack.isEmpty())
        {
            int pos[] = dfsStack.pop();

            if(pos[0] == M - 1 && pos[1] == N - 1)
                return true;

            for(int i = 0; i < 2; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && !checkArr[nx][ny] && numArr[nx][ny] == 1)
                {
                    checkArr[nx][ny] = true;
                    dfsStack.push(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

}