import java.io.*;
import java.util.*;

public class test
{
    static int[][] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException
    {
        list = new int[][]{{1,2},{3,4}};
        check = new boolean[]{false, false}; //조건 판별 체크

        List<Integer> lottoList = new ArrayList<>();
        lotto(1, 0, lottoList);
    }

    static void backTracking(int row, int score)
    {
        if (row == 2) //재귀함수 마치는 조건
        {
            System.out.println(score);
            return;
        }

        for (int i = 0; i < 2; i++)
        {
            if (check[i] == false)
            {
                check[i] = true;
                backTracking(row+1, score + list[row][i]);
                check[i] = false;
            }
        }
    }

    static void lotto(int startIndex, int depth, List<Integer> lottoList)
    {
        if(depth == 6)
        {
            System.out.println(lottoList);
            return;
        }
        else
        {
            for (int i = startIndex; i <= 45; i++)
            {
                lottoList.add(i);
                lotto(i + 1, depth+1, lottoList);
                lottoList.remove(lottoList.size() - 1);
            }
        }
    }
}