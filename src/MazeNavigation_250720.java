import java.io.*;
import java.util.*;

public class MazeNavigation_250720 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point
    {
        int x, y, dist;
        Point(int x, int y, int dist)
        {
            this.x = x; this.y = y; this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
        {
            String line = br.readLine();

            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j) - '0';
        }

        System.out.println(bfs());
    }

    static int bfs()
    {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty())
        {
            Point p = q.poll();
            if (p.x == N-1 && p.y == M-1)
            {
                return p.dist;
            }
            for (int d = 0; d < 4; d++)
            {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M)
                {
                    if (map[nx][ny] == 1 && !visited[nx][ny])
                    {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, p.dist + 1));
                    }
                }
            }
        }
        return -1; // 도달 불가
    }
}
