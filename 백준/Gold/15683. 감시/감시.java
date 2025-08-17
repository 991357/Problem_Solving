import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] mapArr;
    static int MIN;
    static List<int[]> cctvPosList;
    // 부분 집합
    static int[] arr;
    static boolean[] sel;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MIN = Integer.MAX_VALUE;
        mapArr = new int[N][M];

        cctvPosList = new ArrayList<>();

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
            {
                mapArr[i][j] = Integer.parseInt(st.nextToken());
                if (mapArr[i][j] >= 1 && mapArr[i][j] <= 5)
                    cctvPosList.add(new int[]{i, j});
            }
        }

        // CCTV 위치를 갖고 부분 집합 뽑기
        // 원본
        arr = new int[cctvPosList.size()];
        for (int i = 0; i < cctvPosList.size(); i++)
            arr[i] = i;
        sel = new boolean[cctvPosList.size()];

        CCTVSimulator();

        System.out.println(MIN == Integer.MAX_VALUE ? 0 : MIN);

        // 부분 집합을 뽑ㅇ르 때마다 뽑힌 애들 회전 -> 안뽑힌 애들은 그대로

        // CCTV 료이키 텐카이

        // 사각 지대 갯수 확인
    }

    private static void CCTVSimulator()
    {
        // CCTV 개수
        int C = cctvPosList.size();
        if (C == 0) {
            int sum = 0;
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++)
                    if (mapArr[j][k] == 0) sum++;
            MIN = Math.min(MIN, sum);
            return;
        }

        // 각 CCTV의 회전 가짓수(타입별): 1→4, 2→2, 3→4, 4→4, 5→1
        int[] limit = new int[C];
        for (int j = 0; j < C; j++) {
            int x = cctvPosList.get(j)[0], y = cctvPosList.get(j)[1];
            int type = mapArr[x][y];
            limit[j] = (type == 2 ? 2 : (type == 5 ? 1 : 4));
        }

        // 오도미터(다중 for)용 회전 인덱스
        int[] rot = new int[C];

        while (true) {
            // 원본 복사
            int[][] tempMapArr = new int[N][M];
            for (int r = 0; r < N; r++) tempMapArr[r] = mapArr[r].clone();

            // 회전 조합 적용 (isRotate는 항상 true로 전달)
            for (int j = 0; j < C; j++) {
                int cx = cctvPosList.get(j)[0], cy = cctvPosList.get(j)[1];
                int camType = mapArr[cx][cy];
                int r = rot[j];

                switch (camType)
                {
                    case 1:
                        camOneRotate(r, new int[]{cx, cy}, tempMapArr, true);
                        break;
                    case 2:
                        // 네 코드 규칙상 0/2는 좌우, 1/3은 상하처럼 쓰고 있으므로
                        camTwoRotate((r == 0 ? 0 : 1), new int[]{cx, cy}, tempMapArr, true);
                        break;
                    case 3:
                        camThreeRotate(r, new int[]{cx, cy}, tempMapArr, true);
                        break;
                    case 4:
                        camFourRotate(r, new int[]{cx, cy}, tempMapArr, true);
                        break;
                    case 5:
                        camFiveRotate(new int[]{cx, cy}, tempMapArr);
                        break;
                }
            }

            // 사각지대 갱신
            int sum = 0;
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++)
                    if (tempMapArr[j][k] == 0) sum++;
            MIN = Math.min(MIN, sum);

            // 다음 회전 조합으로 증가(오도미터)
            int p = C - 1;
            while (p >= 0) {
                rot[p]++;
                if (rot[p] < limit[p]) break;
                rot[p] = 0; // 자리올림
                p--;
            }
            if (p < 0) break; // 모든 조합 완료
        }
    }

    private static void camFiveRotate(int[] startPos, int[][] tempMapArr)
    {
        tempMapArr[startPos[0]][startPos[1]] = -1;

        for (int d = 0; d < 4; d++)
        {
            int nx = startPos[0] + dx[d];
            int ny = startPos[1] + dy[d];

            while (CheckGo(nx, ny) && tempMapArr[nx][ny] != 6)
            {
                if (tempMapArr[nx][ny] == 0) tempMapArr[nx][ny] = -1;
                nx += dx[d];
                ny += dy[d];
            }
        }
    }


    private static void camFourRotate(int rotateType, int[] startPos, int[][] tempMapArr, boolean isRotate)
    {
        int excludeDir = 1;
        if (isRotate)
        {
            switch (rotateType)
            {
                case 0: excludeDir = 1; break; // 아래 제외
                case 1: excludeDir = 2; break; // 왼쪽 제외
                case 2: excludeDir = 0; break; // 위 제외
                case 3: excludeDir = 3; break; // 오른쪽 제외
            }
        }

        tempMapArr[startPos[0]][startPos[1]] = -1;

        for (int d = 0; d < 4; d++)
        {
            if (d == excludeDir) continue;
            int nx = startPos[0] + dx[d];
            int ny = startPos[1] + dy[d];
            while (CheckGo(nx, ny) && tempMapArr[nx][ny] != 6)
            {
                if (tempMapArr[nx][ny] == 0) tempMapArr[nx][ny] = -1;
                nx += dx[d];
                ny += dy[d];
            }
        }
    }


    private static void camThreeRotate(int rotateType, int[] startPos, int[][] tempMapArr, boolean isRotate)
    {
        int dirA = 0, dirB = 3;
        if (isRotate)
        {
            switch (rotateType)
            {
                case 0: dirA = 0; dirB = 3; break; // 위, 오른쪽
                case 1: dirA = 3; dirB = 1; break; // 오른쪽, 아래
                case 2: dirA = 1; dirB = 2; break; // 아래, 왼쪽
                case 3: dirA = 2; dirB = 0; break; // 왼쪽, 위
            }
        }

        tempMapArr[startPos[0]][startPos[1]] = -1;

        for (int d : new int[]{dirA, dirB})
        {
            int nx = startPos[0] + dx[d];
            int ny = startPos[1] + dy[d];
            while (CheckGo(nx, ny) && tempMapArr[nx][ny] != 6)
            {
                if (tempMapArr[nx][ny] == 0) tempMapArr[nx][ny] = -1;
                nx += dx[d];
                ny += dy[d];
            }
        }
    }


    private static void camTwoRotate(int rotateType, int[] startPos, int[][] tempMapArr, boolean isRotate)
    {
        int[] dirs = (rotateType % 2 == 0) ? new int[]{2, 3} : new int[]{0, 1}; // 2:왼, 3:오, 0:위, 1:아래

        tempMapArr[startPos[0]][startPos[1]] = -1;

        for (int d : dirs)
        {
            int nx = startPos[0] + dx[d];
            int ny = startPos[1] + dy[d];
            while (CheckGo(nx, ny) && tempMapArr[nx][ny] != 6)
            {
                if (tempMapArr[nx][ny] == 0) tempMapArr[nx][ny] = -1; // 감시 표시
                nx += dx[d];
                ny += dy[d];
            }
        }
    }

    private static void camOneRotate(int rotateType, int[] startPos, int[][] tempMapArr, boolean isRotate)
    {
        int dir = 3;
        if (isRotate)
        {
            switch (rotateType)
            {
                case 0: dir = 3; break; // 오른쪽
                case 1: dir = 1; break; // 아래
                case 2: dir = 2; break; // 왼쪽
                case 3: dir = 0; break; // 위
            }
        }

        tempMapArr[startPos[0]][startPos[1]] = -1;

        int nx = startPos[0] + dx[dir];
        int ny = startPos[1] + dy[dir];
        while (CheckGo(nx, ny) && tempMapArr[nx][ny] != 6)
        {
            if (tempMapArr[nx][ny] == 0) tempMapArr[nx][ny] = -1;
            nx += dx[dir];
            ny += dy[dir];
        }
    }


    static boolean CheckGo(int nx, int ny)
    {
        if (nx >= 0 && ny >= 0 && nx < N && ny < M)
            return true;
        else
            return false;
    }
}
