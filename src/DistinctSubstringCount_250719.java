import java.io.*;
import java.util.*;

public class DistinctSubstringCount_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int turn = 1, count = 0;

        while (turn != str.length())
        {
            for (int i = 0; i <= str.length(); i += turn)
                count++;

            turn++;
        }

        System.out.println(count);
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
