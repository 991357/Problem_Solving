import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            String value = st.nextToken();

            for (int i = 0; i < value.length(); i++)
            {
                for (int j = 0; j < n; j++)
                    System.out.print(value.charAt(i));
            }
            System.out.println();
        }
    }
}
