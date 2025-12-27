import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    static int T;

    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++)
        {
            String str = br.readLine();

            // 시작은 0,0
            int[] pos = new int[2];

            // 방향은 북쪽
            int dir = 0;

            // 좌표 크기 저장
            int minX = 0, minY = 0, maxX = 0, maxY = 0;
            
            for(int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) == 'F')
                {
                    // dir 방향으로 이동
                    int nx = pos[0] + dx[dir];
                    int ny = pos[1] + dy[dir];

                    pos = new int[] {nx, ny};

                    minX = Math.min(minX, nx);
                    maxX = Math.max(maxX, nx);
                    minY = Math.min(minY, ny);
                    maxY = Math.max(maxY, ny);
                }
                else if(str.charAt(i) == 'B')
                {
                    // dir 반대로 이동
                    int tempDir = -1;

                    switch (dir) {
                        case 0: // 북
                            tempDir = 2; 
                            break;
                        case 1: // 동
                            tempDir = 3;
                            break;
                        case 2: // 남
                            tempDir = 0;
                            break;
                        case 3: // 서
                            tempDir = 1;
                            break;
                    }

                    int nx = pos[0] + dx[tempDir];
                    int ny = pos[1] + dy[tempDir];

                    pos = new int[]{nx, ny};

                    minX = Math.min(minX, nx);
                    maxX = Math.max(maxX, nx);
                    minY = Math.min(minY, ny);
                    maxY = Math.max(maxY, ny);
                }
                else if(str.charAt(i) == 'L')
                {
                    // dir을 왼쪽으로 회전
                    dir -= 1;
                    if(dir < 0)
                        dir = 3;
                }
                else if(str.charAt(i) == 'R')
                {
                    // dir을 오른쪽으로 회전
                    dir += 1;
                    if(dir > 3)
                        dir = 0;
                }
            }

            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}