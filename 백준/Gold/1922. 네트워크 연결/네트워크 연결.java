import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, totalPrice;
    static int[][] map;

    public static void main(String[] args) throws IOException
    {
        //  초기화
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        totalPrice = 0;

        map = new int[N][N];

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            map[s - 1][e - 1] = p;
            map[e - 1][s - 1] = p;
        }

        // 준비물
        int[] fromArr = new int[N];
        Arrays.fill(fromArr, -1);
        int[] minPriceArr = new int[N];
        Arrays.fill(minPriceArr, Integer.MAX_VALUE);
        boolean[] check = new boolean[N];

        int turn = 0;

        // 0부터 시작
        for (int i = 0; i < N - 1; i++)
        {
            check[turn] = true;
            for (int j = 0; j < map[turn].length; j++)
            {
                if(map[turn][j] != 0 && !check[j])
                {
                    if(map[turn][j] < minPriceArr[j])
                    {
                        minPriceArr[j] = map[turn][j];
                        fromArr[j] = turn;
                    }
                }
            }

            // 다음 턴
            int minTemp = Integer.MAX_VALUE, minIdx = 0;
            for (int j = 0; j < minPriceArr.length; j++)
            {
                if(minPriceArr[j] < minTemp && !check[j])
                {
                    minTemp = minPriceArr[j];
                    minIdx = j;
                }
            }
            turn = minIdx;
        }
        for (int i = 1; i < minPriceArr.length; i++)
            totalPrice += minPriceArr[i];

        System.out.println(totalPrice);
    }
}
