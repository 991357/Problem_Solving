import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static int[] startPos;
    static int[] endPos;
    static boolean[][] checkArr;

    public static void main(String[] args) throws Exception
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++)
        {
            N = Integer.parseInt(br.readLine());

            startPos = new int[2];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++)
                startPos[i] = Integer.parseInt(st.nextToken());

            endPos = new int[2];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 2; i++)
                endPos[i] = Integer.parseInt(st.nextToken());

            bfs();
        }

        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void bfs()
    {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        checkArr = new boolean[N][N];
        checkArr[startPos[0]][startPos[1]] = true;
        bfsQ.offer(new int[]{startPos[0], startPos[1], 0}); //  x좌표, y좌표, 이동횟수

        while(!bfsQ.isEmpty())
        {
            int[] cur = bfsQ.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            if(x == endPos[0] && y == endPos[1])
            {
                sb.append(d).append("\n");
                return;
            }

            // 위로 한칸 와서 양옆 2칸
            int nx_uo = x - 1;
            if(nx_uo >= 0 && nx_uo < N)
            {
                int ny_o = y - 2;
                if(ny_o >= 0 && ny_o < N && !checkArr[nx_uo][ny_o])
                {
                    checkArr[nx_uo][ny_o] = true;
                    bfsQ.offer(new int[]{nx_uo, ny_o, d + 1});
                }

                int ny_t = y + 2;
                if(ny_t >= 0 && ny_t < N && !checkArr[nx_uo][ny_t])
                {
                    checkArr[nx_uo][ny_t] = true;
                    bfsQ.offer(new int[]{nx_uo, ny_t, d + 1});
                }
            }


            // 위로 두칸 와서 양옆 1칸
            int nx_ut = x - 2;
            if(nx_ut >= 0 && nx_ut < N)
            {
                int ny_o = y - 1;
                if(ny_o >= 0 && ny_o < N && !checkArr[nx_ut][ny_o])
                {
                    checkArr[nx_ut][ny_o] = true;
                    bfsQ.offer(new int[]{nx_ut, ny_o, d + 1});
                }

                int ny_t = y + 1;
                if(ny_t >= 0 && ny_t < N && !checkArr[nx_ut][ny_t])
                {
                    checkArr[nx_ut][ny_t] = true;
                    bfsQ.offer(new int[]{nx_ut, ny_t, d + 1});
                }
            }

            // 아래로 한칸 와서 양옆 두칸
            int nx_do = x + 1;
            if(nx_do >= 0 && nx_do < N)
            {
                int ny_o = y - 2;
                if(ny_o >= 0 && ny_o < N && !checkArr[nx_do][ny_o])
                {
                    checkArr[nx_do][ny_o] = true;
                    bfsQ.offer(new int[]{nx_do, ny_o, d + 1});
                }

                int ny_t = y + 2;
                if(ny_t >= 0 && ny_t < N && !checkArr[nx_do][ny_t])
                {
                    checkArr[nx_do][ny_t] = true;
                    bfsQ.offer(new int[]{nx_do, ny_t, d + 1});
                }
            }

            // 아래로 두칸 와서 양옆 한칸
            int nx_dt = x + 2;
            if(nx_dt >= 0 && nx_dt < N)
            {
                int ny_o = y - 1;
                if(ny_o >= 0 && ny_o < N && !checkArr[nx_dt][ny_o])
                {
                    checkArr[nx_dt][ny_o] = true;
                    bfsQ.offer(new int[]{nx_dt, ny_o, d + 1});
                }

                int ny_t = y + 1;
                if(ny_t >= 0 && ny_t < N && !checkArr[nx_dt][ny_t])
                {
                    checkArr[nx_dt][ny_t] = true;
                    bfsQ.offer(new int[]{nx_dt, ny_t, d + 1});
                }
            }
        }

        sb.append(0).append("\n");
    }
}