import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int T, N, W, H, MIN, cnt;
    static int[][] mapArr;
    static int[][] copyMapArr;

    // 조합 변수
    static int[] arr;
    static int[] sel;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++)
        {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            MIN = Integer.MAX_VALUE;
            cnt = 0;

            mapArr = new int[H][W];

            for (int i = 0; i < H; i++)
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++)
                    mapArr[i][j] = Integer.parseInt(st.nextToken());
            }

            // N 개만큼 조합을 뽑을 때 마다.. 시뮬레이션 실행
            arr = new int[W];
            for (int i = 0; i < W; i++)
                arr[i] = i;
            sel = new int[N];

            permutation(0);

            sb.append("#").append(t).append(" ").append(MIN).append("\n");
        }
        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void permutation(int idx)
    {
        // b
        if (idx == N)
        {
            copyMapArr = new int[H][W];

            for (int i = 0; i < H; i++)
            {
                for (int j = 0; j < W; j++)
                    copyMapArr[i][j] = mapArr[i][j];
            }
            Simulation();
            return;
        }

        // i
        for (int i = 0; i < W; i++)
        {
            sel[idx] = arr[i];
            permutation(idx + 1);
        }
    }

    private static void Simulation()
    {
        // sel 만큼 반복해야함

        // sel에 i번째에서 0이 아닌 수를 위에서부터 아래로 돌면서 찾아야함

        // 찾으면 bfs 돌아야함

        // 돌고 나오면 위에서 아래로 애들 내려줘야함

        for (int i = 0; i < sel.length; i++)
        {
            int findY = sel[i];

            int[] pos = findPos(findY);

            if (pos[0] != -1 && copyMapArr[pos[0]][pos[1]] > 1)
                bfs(pos); // bfs 돌아서 근처 애들 다 부수기
            else if (pos[0] != -1 && copyMapArr[pos[0]][pos[1]] == 1)
                copyMapArr[pos[0]][pos[1]] = 0; // 0으로 만들어주기

            RepositionMap();
        }

        // 남은 벽돌 갯수 세기
        cnt = 0;
        for (int i = 0; i < H; i++)
        {
            for (int j = 0; j < W; j++)
            {
                if (copyMapArr[i][j] != 0)
                    cnt++;
            }
        }

        MIN = Math.min(MIN, cnt);
    }

    private static void RepositionMap()
    {
        for (int i = 0; i < W; i++)
        {
            for (int j = H - 1; j >= 0; j--)
            {
                if (copyMapArr[j][i] == 0)
                {
                    // 위로 올라가서 찾기
                    for (int k = j; k >= 0; k--)
                    {
                        if (copyMapArr[k][i] != 0)
                        {
                            copyMapArr[j][i] = copyMapArr[k][i];
                            copyMapArr[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void bfs(int[] pos)
    {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{pos[0], pos[1], copyMapArr[pos[0]][pos[1]]});

        while (!bfsQ.isEmpty())
        {
            int[] cur = bfsQ.poll();

            if (cur[2] == 1)
            {
                copyMapArr[cur[0]][cur[1]] = 0;
                continue;
            }

            for (int i = 0; i < dx.length; i++)
            {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                for (int j = 0; j < cur[2] - 1; j++)
                {
                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && copyMapArr[nx][ny] != 0)
                    {
                        int power = copyMapArr[nx][ny];
                        bfsQ.offer(new int[]{nx, ny, power});
                        copyMapArr[nx][ny] = 0;
                    }

                    nx += dx[i];
                    ny += dy[i];
                }
            }
            copyMapArr[cur[0]][cur[1]] = 0;
        }
    }

    private static int[] findPos(int findY)
    {
        for (int i = 0; i < H; i++)
        {
            if (copyMapArr[i][findY] != 0)
                return new int[]{i, findY};
        }

        return new int[]{-1, -1};
    }
}