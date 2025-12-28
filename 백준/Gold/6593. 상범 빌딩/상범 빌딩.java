import java.io.*;
import java.util.*;

class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] agrs) throws IOException
    {
        while(true)
        {
            int L, R, C;
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)
                break;

            // L개 만큼의 R C 배열을 만들어
            char[][][] mapArr = new char[L][R][C];

            int[] startPos = new int[3]; // 사분면, R , C
            int[] endPos = new int[3];

            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String str = br.readLine();

                    for(int k = 0; k < str.length(); k++) {
                        mapArr[i][j][k] = str.charAt(k);

                        if(mapArr[i][j][k] == 'S')
                            startPos = new int[] {i, j, k};
                        else if(mapArr[i][j][k] == 'E')
                            endPos = new int[] {i, j, k};
                    }
                }
                String temp = br.readLine();
            }

            int res = bfs(L, R, C, mapArr, startPos, endPos);

            if(res == -1)
                sb.append("Trapped!\n");
            else
                sb.append("Escaped in " + res + " minute(s).\n");
        }

        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static int bfs(int L, int R, int C, char[][][] mapArr, int[] startPos, int[] endPos)
    {
        boolean[][][] checkArr = new boolean[L][R][C];
        checkArr[startPos[0]][startPos[1]][startPos[2]] = true; // 시작위치
        Deque<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.add(new int[]{startPos[0], startPos[1], startPos[2], 0});

        while(!bfsQ.isEmpty())
        {
            int[] cur = bfsQ.poll();
            int l = cur[0];
            int r = cur[1];
            int c = cur[2];
            int d = cur[3];

            if(l == endPos[0] && r == endPos[1] && c == endPos[2]){
                return d;
            }

            // 동서남북 먼저 
            for(int i = 0; i < 4; i++)
            {
                int nx = r + dx[i];
                int ny = c + dy[i];
            
                if(nx >= 0 && ny >= 0 && nx < R && ny < C && !checkArr[l][nx][ny] && mapArr[l][nx][ny] != '#') {
                    checkArr[l][nx][ny] = true;
                    bfsQ.add(new int[]{l, nx, ny, d + 1});
                }
            }

            if(l - 1 >= 0) {
                // 이전꺼
                if(mapArr[l-1][r][c] != '#' && !checkArr[l-1][r][c]) {
                    checkArr[l-1][r][c] = true;
                    bfsQ.add(new int[] {l-1, r, c, d + 1});
                }
            }
            if(l + 1 < L) {
                // 다음꺼
                if(mapArr[l+1][r][c] != '#' && !checkArr[l+1][r][c]) {
                    checkArr[l+1][r][c] = true;
                    bfsQ.add(new int[] {l+1, r, c, d + 1});
                }
            }
        }

        return -1;
    }
}