import java.io.*;
import java.util.*;

public class SudokuCorrect {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean isIncorrect;
    static boolean[] check;

    public static void main(String[] args) throws IOException
    {
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++)
        {
            int[][] numArr = new int[9][9];

            for(int i = 0; i < 9; i++)
            {
                String line = br.readLine();

                while (line != null && line.trim().isEmpty())
                    line = br.readLine();

                st = new StringTokenizer(line);

                for (int j = 0; j < 9; j++) {
                    numArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 행 체크
            if(CheckRowAndCol(numArr, true))
            {
                sb.append("#").append(t + 1).append(" ").append(0);
                if(t != T - 1)
                    sb.append("\n");
                continue;
            }
            if(CheckRowAndCol(numArr, false))
            {
                sb.append("#").append(t + 1).append(" ").append(0);
                if(t != T - 1)
                    sb.append("\n");
                continue;
            }
            if(CheckThree(numArr))
            {
                sb.append("#").append(t + 1).append(" ").append(0);
                if(t != T - 1)
                    sb.append("\n");
                continue;
            }
            sb.append("#").append(t + 1).append(" ").append(1);

            if(t != T - 1)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean CheckRowAndCol(int[][] numArr, boolean isRow)
    {
        isIncorrect = false;

        L: for(int i = 0; i < 9; i++)
        {
            check = new boolean[9];

            for(int j = 0; j < 9; j++)
            {
                if(isRow)
                {
                    if(!check[numArr[i][j] - 1])
                        check[numArr[i][j] - 1] = true;
                    else
                    {
                        // 똑같은거 또 들어옴
                        isIncorrect = true;
                        break L;
                    }
                }
                else
                {
                    if(!check[numArr[j][i] - 1])
                        check[numArr[j][i] - 1] = true;
                    else
                    {
                        // 똑같은거 또 들어옴
                        isIncorrect = true;
                        break L;
                    }
                }
            }
        }

        return isIncorrect;
    }

    private static boolean CheckThree(int[][] numArr)
    {
        isIncorrect = false;

        int startR = 0, startC = 0;

        L: for(int i = 0; i < 9; i++)
        {
            check = new boolean[9];

            for(int r = startR; r < startR + 3; r++)
            {
                for(int c = startC; c < startC + 3; c++)
                {
                    if(!check[numArr[r][c] - 1])
                        check[numArr[r][c] - 1] = true;
                    else
                    {
                        // 똑같은거 또 들어옴
                        isIncorrect = true;
                        break L;
                    }
                }
            }
            startC += 3;
            if(startC >= 9)
            {
                startC = 0;
                startR += 3;
            }
        }

        return isIncorrect;
    }
}