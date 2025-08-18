import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L, R, Day;
    static int[][] peopleArr;
    static boolean[][] checkArr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Deque<int[]> bfsQ;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Day = 0;
        peopleArr = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                peopleArr[i][j] = Integer.parseInt(st.nextToken());
        }

        while (true)
        {
            checkArr = new boolean[N][N];

            boolean moved = false;

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (!checkArr[i][j])
                    {
                        if (bfs(i, j))
                            moved = true;
                    }
                }
            }

            if (!moved) break;

            Day++;
        }

        System.out.println(Day);
    }

    private static boolean bfs(int x, int y) {
        bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{x, y});
        checkArr[x][y] = true;

        List<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y});
        int sum = peopleArr[x][y];

        while (!bfsQ.isEmpty())
        {
            int[] pos = bfsQ.poll();

            for (int i = 0; i < 4; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (CheckGo(nx, ny) && CheckAbs(pos, nx, ny))
                {
                    checkArr[nx][ny] = true;
                    bfsQ.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += peopleArr[nx][ny];
                }
            }
        }

        if (union.size() > 1)
        {
            int avg = sum / union.size();

            for (int i = 0; i < union.size(); i++)
            {
                int[] pos = union.get(i);
                peopleArr[pos[0]][pos[1]] = avg;
            }
            return true;
        }
        return false;
    }


    private static boolean CheckAbs(int[] pos, int nx, int ny)
    {
        int abs = Math.abs (peopleArr[pos[0]][pos[1]] - peopleArr[nx][ny]);
        if(abs >= L  && abs <= R)
            return true;
        return false;
    }

    private static boolean CheckGo(int nx, int ny)
    {
        if(nx >= 0 && ny >= 0 && nx < N && ny < N && !checkArr[nx][ny])
            return true;
        return false;
    }
}
