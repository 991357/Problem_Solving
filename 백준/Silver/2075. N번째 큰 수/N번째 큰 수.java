import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < T; i++)
        {
            String space1 = br.readLine();
            StringTokenizer st = new StringTokenizer(space1);

            for (int j = 0; j < T; j++)
                numList.add(Integer.parseInt(st.nextToken()));
        }

        numList.sort(Collections.reverseOrder());

        System.out.println(numList.get(T - 1));
    }
}
