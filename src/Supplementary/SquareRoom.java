package Supplementary;

import java.io.*;
import java.util.*;

public class SquareRoom
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, minStart, maxLength;

    static int[][] map;

    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] memo; // memo[r][c] : r,c에서 출발 했을 때 가본 최대 길이

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++)
        {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            memo = new int[N][N];

            minStart = Integer.MAX_VALUE;
            maxLength = Integer.MIN_VALUE;

            for (int r = 0; r < N; r++)
            {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++)
                    map[r][c] = Integer.parseInt(st.nextToken());
            }

            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    int len = dfs(new Point(r, c, map[r][c]));

                    if(len > maxLength)
                    {
                        maxLength = len;
                        minStart = map[r][c];
                    }
                    else if(len == maxLength)
                        minStart = Math.min(minStart, map[r][c]);
                }
            }
            sb.append("#").append(t).append(" ").append(minStart).append(" ").append(maxLength).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(Point p)
    {
        int len = 1;

        for (int[] delta : deltas)
        {
            int nr = p.r + delta[0];
            int nc = p.c + delta[1];

            if (isIn(nr, nc) && map[nr][nc] == p.h + 1)
            {
                if (memo[nr][nc] != 0)
                    len += memo[nr][nc];
                else
                    len += dfs(new Point(nr, nc, map[nr][nc]));
            }
        }

        return memo[p.r][p.c] = len;
    }

    static boolean isIn(int r, int c)
    {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static class Point
    {
        int r, c, h;

        public Point(int r, int c, int h)
        {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
}
