import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        int zeroCnt = 0, oneCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        StringBuilder tempSb = new StringBuilder(str);

        // zeroCnt의 절반만큼 뒤에서 0 줄이고 oneCnt의 절반만큼 앞에서 1을 줄임
        int minusZeroCnt = zeroCnt / 2;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (minusZeroCnt == 0) {
                break;
            }
            if (str.charAt(i) == '0') {
                tempSb.setCharAt(i, 'x');
                minusZeroCnt--;
            }
        }

        int oneZeroCnt = oneCnt / 2;
        for (int i = 0; i < str.length(); i++) {
            if (oneZeroCnt == 0) {
                break;
            }
            if (str.charAt(i) == '1') {
                tempSb.setCharAt(i, 'x');
                oneZeroCnt--;
            }
        }

        for (int i = 0; i < tempSb.length(); i++) {
            if (tempSb.charAt(i) != 'x') {
                sb.append(tempSb.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
