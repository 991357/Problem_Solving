import java.io.*;
import java.util.*;

public class Main
{
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int count = 1, max = 0;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Character[][] alphaArr = new Character[R][C];
        for(int i = 0; i < R; i++)
        {
            String str = br.readLine();
            String[] temp = str.split("");
            for(int j = 0; j < temp.length; j++)
                alphaArr[i][j] = temp[j].charAt(0);
        }
        boolean[] alphaCheckArr = new boolean[26];
        boolean[][] checkArr = new boolean[R][C];

        Stack<int[]> dfsStack = new Stack<>();
        dfsStack.push(new int[]{0, 0});

        dfs(alphaArr, alphaCheckArr, checkArr, 0, 0, R, C, 1);

        System.out.println(count);
    }

    private static void dfs(Character[][] alphaArr, boolean[] alphaCheckArr, boolean[][] checkArr, int startRow, int startCol, int r, int c, int depth)
    {
        Character start = alphaArr[startRow][startCol];
        alphaCheckArr[start - 'A'] = true;
        checkArr[startRow][startCol] = true;

        // 현재 깊이로 count 갱신
        count = Math.max(count, depth);

        for(int i = 0; i < 4; i++)
        {
            int nx = startRow + dx[i];
            int ny = startCol + dy[i];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c && !checkArr[nx][ny] && !alphaCheckArr[alphaArr[nx][ny] - 'A'])
            {
                checkArr[nx][ny] = true;
                alphaCheckArr[alphaArr[nx][ny] - 'A'] = true;

                dfs(alphaArr, alphaCheckArr, checkArr, nx, ny, r, c, depth + 1);

                checkArr[nx][ny] = false;
                alphaCheckArr[alphaArr[nx][ny] - 'A'] = false;
            }
        }
    }
}