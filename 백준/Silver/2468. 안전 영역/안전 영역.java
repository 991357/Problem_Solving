import java.io.*;
import java.util.*;

public class Main
{
    static int safeArea = 1;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        int areaArr[][] = new int[N][N];

        for(int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
                areaArr[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean checkRainArr[][] = new boolean[N][N];

        for(int k = 0; k < 100; k++)
        {
            // count보다 낮은 지역 물에 잠구기
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (areaArr[i][j] <= k) // 침수 췤
                        checkRainArr[i][j] = true; // 잠김
                }
            }

            // check를 토대로 현재 안전지역 얻어오기
            int safeCount = getSafeCount(checkRainArr, N);

            // 얻어온 안전 지역의 갯수 출력

            // 안전 갯수 > safeArea 라면 -> safeArea 갱신해주기
            if(safeCount > safeArea)
                safeArea = safeCount;
        }

        System.out.println(safeArea);
    }

    private static int getSafeCount(boolean[][] checkRainArr, int n)
    {
        int count = 0;

        // check Rain 복사 배열 하나 만들기
        boolean copyCheckArr[][] = new boolean[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(checkRainArr[i][j])
                    copyCheckArr[i][j] = true;
                else
                    copyCheckArr[i][j] = false;
            }
        }

        // CopyCheck 를 갖고 4방 탐색 + bfs 돌려보기
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!copyCheckArr[i][j])
                {
                    bfs(copyCheckArr, i, j, n);
                    count ++;
                }
            }
        }
        return count;
    }

    private static int bfs(boolean[][] copyCheckArr, int startRow, int startCol, int n)
    {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[]{startRow, startCol});
        copyCheckArr[startRow][startCol] = true;

        int count = 1;

        while (!bfsQ.isEmpty())
        {
            int pos[] = bfsQ.poll();

            for(int i = 0; i < 4; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !copyCheckArr[nx][ny])
                {
                    copyCheckArr[nx][ny] = true;
                    bfsQ.offer(new int[]{nx,ny});
                    count++;
                }
            }
        }

        return count;
    }
}