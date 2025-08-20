import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static char[][] puyoArr;
    static boolean[][] redCheckArr;
    static boolean[][] greenCheckArr;
    static boolean[][] blueCheckArr;
    static boolean[][] yellowCheckArr;
    static boolean[][] purpleCheckArr;
    static Deque<int[]> explodeDeq;
    static Deque<Character> colorDeq;
    static int chainCount;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception
    {
        N = 12;
        M = 6;

        // 초기화
        puyoArr = new char[N][M];
        redCheckArr = new boolean[N][M];
        greenCheckArr = new boolean[N][M];
        blueCheckArr = new boolean[N][M];
        yellowCheckArr = new boolean[N][M];
        purpleCheckArr = new boolean[N][M];
        explodeDeq = new ArrayDeque<>();
        colorDeq = new ArrayDeque<>();
        chainCount = 0;

        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++)
            {
                puyoArr[i][j] = str.charAt(j);

                if(puyoArr[i][j] == 'R')
                    redCheckArr[i][j] = true;
                else if(puyoArr[i][j] == 'G')
                    greenCheckArr[i][j] = true;
                else if(puyoArr[i][j] == 'B')
                    blueCheckArr[i][j] = true;
                else if(puyoArr[i][j] == 'Y')
                    yellowCheckArr[i][j] = true;
                else if(puyoArr[i][j] == 'P')
                    purpleCheckArr[i][j] = true;
            }
        }

        // R B C 가 다 false 라면 break 걸고 나가기
        while (true)
        {
            boolean isFind = false;

            if (CheckTarget('R')) isFind = true;
            if (CheckTarget('G')) isFind = true;
            if (CheckTarget('B')) isFind = true;
            if (CheckTarget('Y')) isFind = true;
            if (CheckTarget('P')) isFind = true;

            if (!isFind) break;

            Explode();
            mapUpdate();
            chainCount++;
        }

        System.out.println(chainCount);
    }

    private static void mapUpdate()
    {
        for (int i = N - 1; i >= 0; i--)
        {
            for (int j = 0; j < M; j++)
            {
                if(puyoArr[i][j] == '.')
                {
                    // 업데이트 필요
                    for (int k = i; k >= 0; k--)
                    {
                        if(puyoArr[k][j] != '.')
                        {
                            // 이 자리에 있는 애랑 나랑 바꿔
                            puyoArr[i][j] = puyoArr[k][j];
                            puyoArr[k][j] = '.';

                            if(puyoArr[i][j] == 'R')
                            {
                                redCheckArr[i][j] = true;
                                redCheckArr[k][j] = false;
                            }
                            else if(puyoArr[i][j] == 'G')
                            {
                                greenCheckArr[i][j] = true;
                                greenCheckArr[k][j] = false;
                            }
                            else if(puyoArr[i][j] == 'B')
                            {
                                blueCheckArr[i][j] = true;
                                blueCheckArr[k][j] = false;
                            }
                            else if(puyoArr[i][j] == 'Y')
                            {
                                yellowCheckArr[i][j] = true;
                                yellowCheckArr[k][j] = false;
                            }
                            else
                            {
                                purpleCheckArr[i][j] = true;
                                purpleCheckArr[k][j] = false;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void Explode()
    {
        while (!explodeDeq.isEmpty())
        {
            int[] cur = explodeDeq.poll();
            char target = colorDeq.poll();

            boolean[][] targetCheckArr;
            if(target == 'R')
                targetCheckArr = redCheckArr;
            else if(target == 'G')
                targetCheckArr = greenCheckArr;
            else if(target == 'B')
                targetCheckArr = blueCheckArr;
            else if(target == 'Y')
                targetCheckArr = yellowCheckArr;
            else
                targetCheckArr = purpleCheckArr;

            puyoArr[cur[0]][cur[1]] = '.';
            targetCheckArr[cur[0]][cur[1]] = false;
        }
    }

    private static boolean CheckTarget(char target)
    {
        boolean isFind = false;

        boolean[][] targetCheckArr;

        if(target == 'R')
            targetCheckArr = redCheckArr;
        else if(target == 'G')
            targetCheckArr = greenCheckArr;
        else if(target == 'B')
            targetCheckArr = blueCheckArr;
        else if(target == 'Y')
            targetCheckArr = yellowCheckArr;
        else
            targetCheckArr = purpleCheckArr;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if(puyoArr[i][j] == target && targetCheckArr[i][j])
                {
                    // bfs
                    List<int[]> tempList = new ArrayList<>();

                    bfs(i, j, target, tempList);

                    if(tempList.size() >= 4)
                    {
                        for (int k = 0; k < tempList.size(); k++)
                        {
                            explodeDeq.offer(tempList.get(k));
                            colorDeq.offer(target);
                        }
                        isFind = true;
                    }
                    else
                    {
                        for (int k = 0; k < tempList.size(); k++)
                        {
                            int[] pos = tempList.get(k);
                            targetCheckArr[pos[0]][pos[1]] = true; // 다시 true 로
                        }
                    }
                }
            }
        }
        return isFind;
    }

    private static void bfs(int x, int y, char target, List<int[]> tempList)
    {
        boolean[][] targetCheckArr;

        if(target == 'R')
            targetCheckArr = redCheckArr;
        else if(target == 'G')
            targetCheckArr = greenCheckArr;
        else if(target == 'B')
            targetCheckArr = blueCheckArr;
        else if(target == 'Y')
            targetCheckArr = yellowCheckArr;
        else
            targetCheckArr = purpleCheckArr;

        // 초기 세팅
        Deque<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[]{x, y});
        targetCheckArr[x][y] = false;
        tempList.add(new int[]{x, y});

        while (!bfsQ.isEmpty())
        {
            int[] pos = bfsQ.poll();

            for (int i = 0; i < dx.length; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && targetCheckArr[nx][ny] && puyoArr[nx][ny] == target)
                {
                    targetCheckArr[nx][ny] = false;
                    bfsQ.offer(new int[]{nx, ny});
                    tempList.add(new int[]{nx, ny});
                }
            }
        }
    }
}
