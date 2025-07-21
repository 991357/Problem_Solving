import java.io.*;
import java.util.*;

public class NonFinisher_250721
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a[] = new String[]{"mislav", "stanko", "mislav", "ana"};
        String b[] = new String[]{"stanko", "ana", "mislav"};

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }


    class Solution
    {
        public String solution(String[] participant, String[] completion)
        {
            Map<String, Integer> playerMap = new HashMap<>();

            for (int i = 0; i < participant.length; i++)
                playerMap.put(participant[i], playerMap.getOrDefault(participant[i], 0) + 1);

            for (int i = 0; i < completion.length; i++)
                playerMap.put(completion[i], playerMap.getOrDefault(completion[i], 0) - 1);

            for (Map.Entry<String, Integer> entry : playerMap.entrySet())
            {
                if (entry.getValue() == 1)
                    return entry.getKey();
            }

            return null;
        }
    }
}
