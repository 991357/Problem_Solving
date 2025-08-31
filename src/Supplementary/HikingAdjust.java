package Supplementary;

import java.io.*;
import java.util.*;

public class HikingAdjust
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, K;
    static int[][] map;
    static int maxHeight;
    static int maxPathLength; // 최대 등산로 길이

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            maxHeight = 0;
            maxPathLength = 0;

            for(int r = 0; r < N; r++)
            {
                st = new StringTokenizer(br.readLine());
                for(int c= 0; c< N; c++)
                {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[r][c]);
                }
            }

            for(int r = 0; r < N; r++)
            {
                for(int c = 0; c < N; c++)
                {
                    // 탐색 시작
                    if(map[r][c] == maxHeight)
                    {
                        //dfs(new Point(r, c, map[r][c], 1, true);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(maxPathLength).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(Point p)
    {

    }

    static class Point
    {
        int r, c, h, l;
        boolean canDig;

        Point(int r, int c, int h, int l)
        {
            this.r = r;
            this.c = c;
            this.h = h;
            this.l = l;
        }
    }
}
