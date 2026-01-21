import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[][] stuArr = new int[N][5];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++)
                stuArr[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int[] maxArr = new int[5];

        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                int[] temp = new int[5];
                temp[i] = 1;
                temp[j] = 1;

                int allOneCnt = 0;
                for(int k = 0; k < N; k++) {
                    if(stuArr[k][i] == 1 && stuArr[k][j] == 1) {
                        allOneCnt++;
                    }
                }

                if(allOneCnt > max) {
                    max = allOneCnt;
                    maxArr = temp;
                }
            }
        }
        sb.append(max).append("\n");
        if(max == 0)
        {
            maxArr[0] = 1;
            maxArr[1] = 1;
        }
        for(int i = 0; i < 5; i++) {
            sb.append(maxArr[i]).append(" ");
        }
        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
}