package dp;

public class dp3_dfs_이차원배열
{
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N = 3;
    static int[][] map;
    static boolean[][] v;
    static int cnt;
    static int total = 0;

    public static void main(String[] args)
    {
        /*
         * dfs를 이용한 완탐
         */
        map = new int[N][N];
        v = new boolean[N][N];
        v[0][0] = true;
        map[0][0] = 1;
        cnt = 1;
        total = 0;
        dfs(0, 0);
        print(map);
        System.out.println("total : " + total);
        System.out.println("------------dfs ----------------");

        /*
         * backtracking 을 이용한 dfs 검색
         */
        map = new int[N][N];
        v = new boolean[N][N];
        map[0][0] = 1;
        v[0][0] = true;
        cnt = 1;
        total = 0;
        dfs1(0, 0);
        print(map);
        System.out.println("total : " + total);
        System.out.println("------------dfs1----------------");

        /*
         * 리턴 재귀를 이용한 dfs
         */
        map = new int[N][N];
        v = new boolean[N][N];
        map[0][0] = 1;
        v[0][0] = true;
        total = 0;
        dfs2(0, 0);
        print(map);
        System.out.println("total : " + total);
        System.out.println("------------dfs2---------------");

        /*
         * 재귀함수 호출시 바로 return 하는 dfs
         */
        map = new int[N][N];
        v = new boolean[N][N];
        map[0][0] = 1;
        v[0][0] = true;
        total = 0;
        dfs3(0, 0);
        print(map);
        System.out.println("total : " + total);
        System.out.println("------------dfs3---------------");

    }


    private static int dfs3(int r, int c)
    {

        if (r == N - 1 && c == N - 1)
        {
            total++;
            map[r][c] = 1;
            return 1;
        }

        for (int d = 0; d < 4; d++)
        {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc])
            {
                return map[r][c] = Math.max(map[r][c], dfs3(nr, nc) + 1);
            }
        }
        //System.out.println("111111111");
        return map[r][c];
    }

    private static int dfs2(int r, int c)
    {
        if (r == N - 1 && c == N - 1)
        {
            total++;
            map[r][c] = 1;
            return 1;
        }

        for (int d = 0; d < 4; d++)
        {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc])
            {
                v[nr][nc] = true;
                //map[r][c]= dfs2(nr,nc)+1;
                // 리턴재귀를 여러개가 리턴되기 때문에 집계함수가 필요하다
                map[r][c] = Math.max(map[r][c], dfs2(nr, nc) + 1);
                v[nr][nc] = false;
            }
        }

        return map[r][c];
    }


    private static void dfs1(int r, int c)
    {
        if (r == N - 1 && c == N - 1)
        {
            total++;
            return;
        }

        for (int d = 0; d < 4; d++)
        {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc])
            {
                v[nr][nc] = true;
                map[nr][nc] = cnt++;
                dfs1(nr, nc);
                v[nr][nc] = false;
            }
        }

    }

    private static void dfs(int r, int c)
    {
        if (r == N - 1 && c == N - 1)
        {
            total++;
            return;
        }

        for (int d = 0; d < 4; d++)
        {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc])
            {
                v[nr][nc] = true;
                map[nr][nc] = cnt++;
                dfs(nr, nc);
            }
        }
    }

    private static void print(int[][] map)
    {
        for (int r = 0; r < map.length; r++)
        {
            for (int c = 0; c < map[r].length; c++)
            {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
