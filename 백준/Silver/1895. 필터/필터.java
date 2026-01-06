import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R, C, T;
    static List<Integer> middleList;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        middleList = new ArrayList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[][] numArr = new int[R][C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++)
                numArr[i][j] = Integer.parseInt(st.nextToken());
        }

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                makeThree(i, j, numArr); // 3*3을 만들어보고 가능하면 가운데 값
            }
        }

        int cnt = 0;
        for (int i = 0; i < middleList.size(); i++) {
            if(middleList.get(i) >= T)
                cnt++;
        }

        System.out.println(cnt);
    }

    private static void makeThree(int r, int c, int[][] numArr)
    {
        List<Integer> tempList = new ArrayList<>();

        L : for(int i = r; i < r + 3; i++) {
            for(int j = c; j < c + 3; j++)
            {
                if(j >= C || i >= R)
                    break L;
                tempList.add(numArr[i][j]);
            }
        }

        if(tempList.size() == 9) {
            Collections.sort(tempList);
            middleList.add(tempList.get(4));
        }
    }
}
