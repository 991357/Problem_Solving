import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 123456789;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String str;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == INF) {
                continue;
            }

            // 여기서 갈 수 있는 모든 길을 찾아
            for (int j = i + 1; j < N; j++) {
                boolean canJump = false;
                if (str.charAt(i) == 'B' && str.charAt(j) == 'O') {
                    canJump = true;
                } else if (str.charAt(i) == 'O' && str.charAt(j) == 'J') {
                    canJump = true;
                } else if (str.charAt(i) == 'J' && str.charAt(j) == 'B') {
                    canJump = true;
                }
                if (canJump) {
                    dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                }
            }
        }
        System.out.println(dp[N - 1] == INF ? -1 : dp[N - 1]);
    }
}
