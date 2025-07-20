import java.io.*;
import java.util.*;

public class CoordinateCompression_250720
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int numArr[] = new int[N];
        Set<Integer> tempSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++)
        {
            numArr[i] = Integer.parseInt(st.nextToken());
            tempSet.add(numArr[i]);
        }

        List<Integer> tempList = new ArrayList<>(tempSet);
        Collections.sort(tempList);

        Map<Integer, Integer> compressMap = new HashMap<>();
        for (int i = 0; i < tempList.size(); i++)
            compressMap.put(tempList.get(i), i);

        StringBuilder sb = new StringBuilder();
        for (int num : numArr)
            sb.append(compressMap.get(num) + " ");
        System.out.println(sb);
    }
}
