import java.io.*;
import java.util.*;

public class ChessPaint_250714
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++)
            board[i] = br.readLine().toCharArray();

        int minCount = Integer.MAX_VALUE;

        for (int x = 0; x <= N - 8; x++)
        {
            for (int y = 0; y <= M - 8; y++)
                minCount = Math.min(minCount, getRepaintCount(board, x, y));
        }

        System.out.println(minCount);
    }

    private static int getRepaintCount(char[][] board, int startX, int startY)
    {
        int countW = 0;
        int countB = 0;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                char current = board[startX + i][startY + j];

                if ((i + j) % 2 == 0)
                {
                    if (current != 'W') countW++;
                    if (current != 'B') countB++;
                }
                else
                {
                    if (current != 'B') countW++;
                    if (current != 'W') countB++;
                }
            }
        }

        return Math.min(countW, countB);
    }
}
