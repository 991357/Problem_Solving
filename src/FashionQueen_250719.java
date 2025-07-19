import java.io.*;
import java.util.*;

public class FashionQueen_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 0; test_case < T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> clothMap = new HashMap<>();

            for (int i = 0; i < N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();

                clothMap.put(type, clothMap.getOrDefault(type, 0) + 1);
            }

            int addSum = 1;
            for (Map.Entry<String, Integer> entry : clothMap.entrySet())
            {
                addSum *= (entry.getValue() + 1);
            }

            sb.append(addSum-1).append("\n");
        }

        System.out.println(sb);
    }
}
