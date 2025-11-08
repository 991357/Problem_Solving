import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<String> numList;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());

        numList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numList.add(st.nextToken());

        numList.sort(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });

        for(String s : numList)
            sb.append(s);

        if(sb.charAt(0) == '0')
            System.out.println(0);
        else
            System.out.println(sb);
    }
}