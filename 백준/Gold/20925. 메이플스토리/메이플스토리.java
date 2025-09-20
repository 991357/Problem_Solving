import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class AngelicBuster
    {
        int turn, exp;

        public AngelicBuster()
        {
            turn = 0; // 난 지금 몇번째 사냥터를 조@져야 하나?
            exp = 0; // 내 경험치가 몇인가?
        }

        // 🚀엔젤릭버스터가 사냥할 곳 탐색중..🚀
        public void setHunt()
        {
            for (int i = 0; i < N; i++)
            {
                if (exp >= huntArr[i].needExp)
                    turn = i; // i번째 사냥터 갈 차례
            }
        }
    }

    static class Hunt
    {
        int needExp, getExp;

        public Hunt(int needExp, int getExp)
        {
            this.needExp = needExp;
            this.getExp = getExp;
        }
    }

    static int N, T, curTime;
    static Hunt[] huntArr;
    static AngelicBuster anbu;
    static int[][] moveTimeArr;
    static int[] nextExpArr;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        curTime = 0;

        huntArr = new Hunt[N];
        nextExpArr = new int[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int ne = Integer.parseInt(st.nextToken());
            int ge = Integer.parseInt(st.nextToken());
            nextExpArr[i] = ne;
            huntArr[i] = new Hunt(ne, ge);
        }

        // 다음 사냥터까지 얼마나 필요한지 정렬 해놓기
        Arrays.sort(nextExpArr);

        // 🔥🔥🔥🔥 엔젤릭버스터 ⭐등 장⭐ 🔥🔥🔥🔥
        anbu = new AngelicBuster();
        anbu.setHunt();

        moveTimeArr = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                moveTimeArr[i][j] = Integer.parseInt(st.nextToken());
        }

        // DP: dp[t][i] = t분에 i 사냥터에 있을 때 가능한 최대 경험치 (도달 불가=-1)
        long[][] dp = new long[T + 1][N];
        for (int t = 0; t <= T; t++) Arrays.fill(dp[t], -1);

        for (int i = 0; i < N; i++) if (huntArr[i].needExp == 0) dp[0][i] = 0;

        while (true)
        {
            if (curTime >= T)
                break;

            // 사냥 조@지기
            for (int i = 0; i < N; i++)
            {
                long val = dp[curTime][i];
                if (val < 0) continue;
                if (val >= huntArr[i].needExp)
                    dp[curTime + 1][i] = Math.max(dp[curTime + 1][i], val + huntArr[i].getExp);
            }

            // 다음 사냥터로 갈 준비 완⭐료
            for (int i = 0; i < N; i++)
            {
                long val = dp[curTime][i];
                if (val < 0) continue;
                for (int j = 0; j < N; j++)
                {
                    int w = moveTimeArr[i][j];
                    int arrive = curTime + w;
                    if (arrive <= T && val >= huntArr[j].needExp)
                        dp[arrive][j] = Math.max(dp[arrive][j], val);
                }
            }
            curTime++;
        }

        long ans = 0;

        for (int i = 0; i < N; i++)
            ans = Math.max(ans, dp[T][i]);

        System.out.println(ans);
    }
}

/*
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀? 맞왜틀?
*/