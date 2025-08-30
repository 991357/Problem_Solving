import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] paperArr;
    static int whiteCnt, blueCnt;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        paperArr = new int[N][N];

        whiteCnt = 0;
        blueCnt = 0;

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                paperArr[i][j] = Integer.parseInt(st.nextToken());
        }

        DivisionPaper(0, 0, N);

        sb.append(whiteCnt).append("\n").append(blueCnt);
        System.out.println(sb);
    }

    private static void DivisionPaper(int x, int y, int size)
    {
        // chek
        if(CheckPaper(x, y, size))
        {
            if(paperArr[x][y] == 1) blueCnt++;
            else whiteCnt++;

            return;
        }
        // 1 2 3 4 분면
        int newSize = size / 2;

        DivisionPaper(x, y, newSize);
        DivisionPaper(x+newSize, y, newSize);
        DivisionPaper(x, y + newSize, newSize);
        DivisionPaper(x+newSize, y + newSize, newSize);
    }

    private static boolean CheckPaper(int x, int y, int size)
    {
        int type = paperArr[x][y]; // 1 이면 파란색, 0이면 하얀색

        for (int i = x; i < x + size; i++)
        {
            for (int j = y; j < y + size; j++)
            {
                if(paperArr[i][j] != type)
                    return false;
            }
        }
        return true;
    }
}