import java.io.*;
import java.util.*;

public class OfficeEnter_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> employeeMap = new HashMap<>();

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String type = st.nextToken();


        }
    }
}
