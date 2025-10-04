package BGrade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{

    private final static int CMD_INIT = 1;
    private final static int CMD_DRAW = 2;
    private final static int CMD_RECT = 3;
    private final static int CMD_CNT = 4;

    private final static UserSolution usersolution = new UserSolution();

    private static boolean run(BufferedReader br) throws Exception
    {

        int query_num = Integer.parseInt(br.readLine());
        boolean ok = false;

        for (int q = 0; q < query_num; q++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int query = Integer.parseInt(st.nextToken());

            if (query == CMD_INIT)
            {
                int L = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());
                usersolution.init(L, N);
                ok = true;
            } else if (query == CMD_DRAW)
            {
                int mID = Integer.parseInt(st.nextToken());
                int mRow = Integer.parseInt(st.nextToken());
                int mCol = Integer.parseInt(st.nextToken());
                int mHeight = Integer.parseInt(st.nextToken());
                int mWidth = Integer.parseInt(st.nextToken());
                int ret = usersolution.draw(mID, mRow, mCol, mHeight, mWidth);
                int ans = Integer.parseInt(st.nextToken());
                if (ans != ret)
                {
                    ok = false;
                }
            } else if (query == CMD_RECT)
            {
                int mID = Integer.parseInt(st.nextToken());
                int ret = usersolution.getRectCount(mID);
                int ans = Integer.parseInt(st.nextToken());
                if (ans != ret)
                {
                    ok = false;
                }
            } else if (query == CMD_CNT)
            {
                int ret = usersolution.countGroup();
                int ans = Integer.parseInt(st.nextToken());
                if (ans != ret)
                {
                    ok = false;
                }
            }
        }
        return ok;
    }

    public static void main(String[] args) throws Exception
    {
        int T, MARK;
        // System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        T = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++)
        {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + tc + " " + score);
        }
        br.close();
    }
}