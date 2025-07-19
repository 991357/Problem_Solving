import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        char chessPanArr[][] = new char[N][M];

        for (int i = 0; i < N; i++)
        {
            String temp = br.readLine();

            for (int j = 0; j < temp.length(); j++)
                chessPanArr[i][j] = temp.charAt(j);
        }

        int minChangeCount = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++)
        {
            for (int j = 0; j < M - 7; j++)
            {
                char[][] tempArr = new char[chessPanArr.length][chessPanArr[0].length];

                for (int k = 0; k < chessPanArr.length; k++)
                    tempArr[k] = Arrays.copyOf(chessPanArr[k], chessPanArr[k].length);

                int temp = CountChangePanel(tempArr,i, j);
                minChangeCount = Integer.min(minChangeCount, temp);
            }
        }

        System.out.println(minChangeCount);
    }

    public static int CountChangePanel(char[][] chessPan,  int colIndex, int rowIndex)
    {
        int count = 0;

        for (int i = colIndex; i < 8 + colIndex; i ++)
        {
            if(i == 7 + colIndex)
                break;

            for (int j = rowIndex; j < 8 + rowIndex; j++)
            {
                if(j == 7 + rowIndex)
                    break;
                if(chessPan[i][j] == 'W' && chessPan[i+1][j] == 'W')
                {
                    chessPan[i+1][j] = 'B';
                    count++;
                }
                else if(chessPan[i][j] == 'B' && chessPan[i+1][j] == 'B')
                {
                    chessPan[i+1][j] = 'W';
                    count++;
                }
                if(chessPan[i][j] == 'W' && chessPan[i][j+1] == 'W')
                {
                    chessPan[i][j+1] = 'B';
                    count++;
                }
                else if(chessPan[i][j] == 'B' && chessPan[i][j+1] == 'B')
                {
                    chessPan[i][j+1] = 'W';
                    count++;
                }
            }
        }

        return count;
    }
}
