import java.io.*;
import java.util.*;

public class swea_micro
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int T, N, M, K, sum;

    static class MicroOrganism
    {
        int x, y, c, d;
        boolean isCombine;

        // 생성자
        public MicroOrganism(int x, int y, int c, int d, boolean isCombine)
        {
            this.x = x; // 행
            this.y = y; // 열
            this.c = c; // 미생물 수
            this.d = d; // 방향
            this.isCombine = isCombine;
        }

        public void MoveMicro()
        {
            if (this.isCombine)
                return;

            this.x = this.x + dx[d];
            this.y = this.y + dy[d];

            checkMedicine();
        }

        public void ChangeDir()
        {
            if (this.d == 0)
                this.d = 1;
            else if (this.d == 1)
                this.d = 0;
            else if (this.d == 2)
                this.d = 3;
            else if (this.d == 3)
                this.d = 2;
        }

        public void ReachMedicine()
        {
            this.c = (int)(this.c / 2);
            ChangeDir();
        }

        public void checkMedicine()
        {
            if (this.x >= 0 && this.x < N && this.y == 0) // 왼쪽
                ReachMedicine();
            else if (this.x >= 0 && this.x < N && this.y == N - 1) // 오른쪽
                ReachMedicine();
            else if (this.y >= 0 && this.y < N && this.x == 0) // 위
                ReachMedicine();
            else if (this.y >= 0 && this.y < N && this.x == N - 1) // 아래
                ReachMedicine();
        }
    }

    static int[][] mapArr;
    static MicroOrganism[] microOrganismArr;

    public static void main(String[] args) throws IOException
    {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            mapArr = new int[N][N];
            microOrganismArr = new MicroOrganism[K];

            for (int i = 0; i < K; i++)
            {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                microOrganismArr[i] = new MicroOrganism(x, y, c, d - 1, false);

                mapArr[x][y]++;
            }

            for (int i = 0; i < M; i++)
            {
                for (int j = 0; j < K; j++)
                {
                    MicroOrganism m = microOrganismArr[j];

                    mapArr[m.x][m.y]--;
                    m.MoveMicro();
                    mapArr[m.x][m.y]++;

                }
                MicroCombine();
            }

            sum = 0;

            for (int i = 0; i < microOrganismArr.length; i++)
            {
                if (!microOrganismArr[i].isCombine)
                    sum += microOrganismArr[i].c;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void MicroCombine()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (mapArr[i][j] >= 2)
                {
                    Deque<MicroOrganism> tempQ = new ArrayDeque<>();
                    int maxCount = 0;
                    MicroOrganism biggerMicro = null;

                    for (int k = 0; k < microOrganismArr.length; k++)
                    {
                        if (microOrganismArr[k].x == i && microOrganismArr[k].y == j && !microOrganismArr[k].isCombine)
                        {
                            tempQ.offer(microOrganismArr[k]);

                            if (maxCount < microOrganismArr[k].c)
                            {
                                maxCount = microOrganismArr[k].c;
                                biggerMicro = microOrganismArr[k];
                            }
                        }
                    }
                    while (!tempQ.isEmpty())
                    {
                        MicroOrganism cur = tempQ.poll();

                        if (cur != biggerMicro)
                        {
                            biggerMicro.c += cur.c;
                            cur.isCombine = true;
                        }
                    }
                }
            }
        }
    }
}