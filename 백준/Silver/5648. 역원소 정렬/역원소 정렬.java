import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        String[] numArr = new String[N];
        int idx = 0;

        while (st.hasMoreTokens() && idx < N) {
            numArr[idx++] = st.nextToken();
        }

        while (idx < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && idx < N) {
                numArr[idx++] = st.nextToken();
            }
        }

        for (int i = 0; i < numArr.length; i++) {
            StringBuffer sbf = new StringBuffer();
            sbf.append(numArr[i]);
            sbf.reverse();
            String reversed = sbf.toString();
            numArr[i] = String.valueOf(Long.parseLong(reversed));
        }

        Arrays.sort(numArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }
                return Long.compare(Long.parseLong(o1), Long.parseLong(o2));
            }
        });

        for (String s : numArr) {
            sb.append(s).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        System.out.println(sb);
    }
}