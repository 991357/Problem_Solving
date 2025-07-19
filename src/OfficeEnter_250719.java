import java.io.*;
import java.util.*;

public class OfficeEnter_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> employeeMap = new HashMap<>();

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String type = st.nextToken();

            employeeMap.put(name, type);
        }

        List<String> names = new ArrayList<>();
        for (Map.Entry<String, String> entry : employeeMap.entrySet())
            if (entry.getValue().equals("enter"))
                names.add(entry.getKey());

        Collections.sort(names, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : names)
            sb.append(name).append("\n");

        System.out.print(sb);


        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
