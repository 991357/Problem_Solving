import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] areaArr;
    static boolean[][] check;

    static boolean[][] checkPointArr;

    static int MIN = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<int[]> explorePosSet = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        areaArr = new int[N][N];
        checkPointArr = new boolean[N][N];

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                areaArr[i][j] = Integer.parseInt(st.nextToken());
       }
        check = new boolean[N][N];

        // 탐색
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(areaArr[i][j] == 1)
                {
                    FindIsland(i, j);

                    for(int[] pos : explorePosSet)
                    {
                        boolean[][] checkSea = new boolean[N][N];
                        int[][] distArr = new int[N][N];
                        ExploreSea(pos, checkSea, distArr);
                    }
                    break;
                }
            }
        }

        System.out.println(MIN);
    }

    private static void ExploreSea(int[] pos, boolean[][] checkSea, int[][] distArr)
    {
        // 여기서 출발 할 수 있는 곳 좌표 얻기
        Deque<int[]> bfsQ = new ArrayDeque<>();

        for(int i = 0; i < dx.length; i++)
        {
            int nx = pos[0] + dx[i];
            int ny = pos[1] + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && areaArr[nx][ny] == 0)
            {
                checkSea[nx][ny] = true;
                distArr[nx][ny] = 1;
                bfsQ.offer(new int[] {nx, ny});
            }
        }

        while (!bfsQ.isEmpty())
        {
            int[] seaPos = bfsQ.poll();

            // 싹둑싹둑~
            if(distArr[seaPos[0]][seaPos[1]] > MIN)
                continue;

            for(int i = 0; i < dx.length; i++)
            {
                int nx = seaPos[0] + dx[i];
                int ny = seaPos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !checkSea[nx][ny] && areaArr[nx][ny] == 0 && !check[nx][ny])
                {
                    bfsQ.offer(new int[]{nx, ny});
                    checkSea[nx][ny] = true;
                    distArr[nx][ny] = distArr[seaPos[0]][seaPos[1]] + 1;
                }
                else if(nx >= 0 && ny >= 0 && nx < N && ny < N && !checkSea[nx][ny] && areaArr[nx][ny] == 1 && !check[nx][ny])
                    MIN = Math.min(MIN, distArr[seaPos[0]][seaPos[1]]);
            }
        }
    }

    // 항해 할 수 있는 좌표 얻어오기
    private static void FindIsland(int x, int y)
    {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        check[x][y] = true;
        bfsQ.offer(new int[]{x,y});

        while (!bfsQ.isEmpty())
        {
            int[] pos = bfsQ.poll();

            // 재귀
            for(int i = 0; i < dx.length; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny] && areaArr[nx][ny] == 1)
                {
                    check[nx][ny] = true;
                    bfsQ.offer(new int[]{nx, ny});
                }
                else if(nx >= 0 && ny >= 0 && nx < N && ny < N && !check[nx][ny] && areaArr[nx][ny] == 0)
                {
                    if(!checkPointArr[pos[0]][pos[1]])
                    {
                        checkPointArr[pos[0]][pos[1]] = true;
                        explorePosSet.add(new int[]{pos[0], pos[1]});
                    }
                }
            }
        }
    }
}