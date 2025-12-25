import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        int totalSeconds = A * 3600 + B * 60 + C + D;

        totalSeconds %= 24 * 3600;

        int hour = totalSeconds / 3600;
        totalSeconds %= 3600;
        int minute = totalSeconds / 60;
        int second = totalSeconds % 60;

        System.out.println(hour + " " + minute + " " + second);
    }
}
