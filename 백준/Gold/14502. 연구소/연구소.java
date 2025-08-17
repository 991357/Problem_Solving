import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K;
    static int MAX;

    static int[][] mapArr;
    static List<int[]> candidateList;
    static List<int[]> virusPosList;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = 3;
        MAX = 0;
        candidateList = new ArrayList<>();
        virusPosList = new ArrayList<>();

        mapArr = new int[N][M];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
            {
                mapArr[i][j] = Integer.parseInt(st.nextToken());
                if(mapArr[i][j] == 0)
                    candidateList.add(new int[]{i, j});
                else if(mapArr[i][j] == 2)
                    virusPosList.add(new int[]{i,j});
            }
        }

        // 조합을 뽑고 조합을 뽑을 때 마다 벽을 세워보고 바이러스를 퍼뜨려본다.
        // 그 때 안전영역의 크기를 계산해서 MIN 값에 업데이트 한다.
        // 이게 끝나면 해당 부분을 다시 0으로 되돌려 놓아야한다.
        int[] arr = new int[candidateList.size()];
        for (int i = 0; i < candidateList.size(); i++)
            arr[i] = i;
        int[] sel = new int[K];
        Combination(arr, sel,0, 0);
        System.out.println(MAX);
    }

    private static void Combination(int[] arr, int[] sel, int idx, int k)
    {
        if(k == K)
        {
            //System.out.println(Arrays.toString(sel));
            // sel 에 담겨 있는 번째 좌표에 1을 세워봐
            List<int[]> temp = new ArrayList<>();
            for (int i = 0; i < sel.length; i++)
                temp.add(candidateList.get(sel[i]));

            for (int i = 0; i < temp.size(); i++)
                mapArr[temp.get(i)[0]][temp.get(i)[1]] = 1; // 가벽

            // BFS 돌고 와
            CheckLaboratory();

            for (int i = 0; i < temp.size(); i++)
                mapArr[temp.get(i)[0]][temp.get(i)[1]] = 0; // 가벽 해제

            return;
        }

        if(idx == candidateList.size()) return;

        sel[k] = arr[idx];
        Combination(arr, sel, idx + 1, k + 1);
        Combination(arr, sel, idx + 1, k);
    }

    private static void CheckLaboratory()
    {
        // 원본 복사
        int[][] tempMapArr = new int[N][M];

        for (int i = 0; i < N; i++)
        {
            int[] temp = new int[M];
            for (int j = 0; j < M; j++)
                temp[j] = mapArr[i][j];
            tempMapArr[i] = temp;
        }

        boolean[][] check = new boolean[N][M];

        // 2를 다 탐색 해봐
        for (int i = 0; i < virusPosList.size(); i++)
            bfs(tempMapArr, check, virusPosList.get(i));

        // 0의 크기를 계산해봐
        int sumTemp = 0;
        for (int i = 0; i < tempMapArr.length; i++)
        {
            for (int j = 0; j < tempMapArr[i].length; j++)
            {
                if(tempMapArr[i][j] == 0)
                    sumTemp++;
            }
        }

        MAX = Math.max(MAX, sumTemp);
    }

    private static void bfs(int[][] tempMapArr, boolean[][] check, int[] startVirusPos)
    {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        check[startVirusPos[0]][startVirusPos[1]] = true; // 여긴 들렀다.
        bfsQ.offer(startVirusPos);

        while (!bfsQ.isEmpty())
        {
            int[] pos = bfsQ.poll();

            for (int i = 0; i < dx.length; i++)
            {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny] && tempMapArr[nx][ny] == 0)
                {
                    tempMapArr[nx][ny] = 2;
                    check[nx][ny] = true;
                    bfsQ.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
