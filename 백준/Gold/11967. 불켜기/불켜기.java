import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, lightCount;
    static int[][] mapArr;
    static boolean[][] lightArr;
    static boolean[][] visitedArr;
    static List<int[]>[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mapArr = new int[N][N];
        lightArr = new boolean[N][N];
        visitedArr = new boolean[N][N];
        lightArr[0][0] = true;
        lightCount = 0;

        arr = new List[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                arr[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            arr[sx - 1][sy - 1].add(new int[]{ex - 1, ey - 1});
        }

        bfs();

        for (int i = 0; i < lightArr.length; i++)
        {
            for (int j = 0; j < lightArr[i].length; j++)
            {
                if(lightArr[i][j])
                    lightCount++;
            }
        }

        //boolean[][] checkArr = new boolean[N][N];
        //TrueBfs(checkArr);

        System.out.println(lightCount);
    }

    private static void bfs()
    {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visitedArr[0][0] = true;

        while(!q.isEmpty())
        {
            int[] pos = q.poll();

            for(int[] room : arr[pos[0]][pos[1]])
            {
                if(!lightArr[room[0]][room[1]])
                {
                    lightArr[room[0]][room[1]] = true;

                    // 새로 켠 방이 방문 가능하다면 큐에 넣기
                    for(int d=0; d<4; d++)
                    {
                        int nx = room[0] + dx[d];
                        int ny = room[1] + dy[d];

                        if(nx>=0 && ny>=0 && nx<N && ny<N && visitedArr[nx][ny])
                        {
                            q.offer(new int[]{room[0], room[1]});
                            visitedArr[room[0]][room[1]] = true;
                            break;
                        }
                    }
                }
            }

            for(int d=0; d<4; d++)
            {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];

                if(nx>=0 && ny>=0 && nx<N && ny<N && lightArr[nx][ny] && !visitedArr[nx][ny])
                {
                    visitedArr[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
