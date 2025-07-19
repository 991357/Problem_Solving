import java.io.*;
import java.util.*;

public class Symmetric_Difference_250719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st1.nextToken()), B = Integer.parseInt(st1.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++)
            aSet.add(Integer.parseInt(st2.nextToken()));

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++)
            bSet.add(Integer.parseInt(st3.nextToken()));

        // A - B
        int aCount = 0;

        for (Integer n : aSet)
        {
            if(!bSet.contains(n))
                aCount++;
        }

        // B - A
        int bCount = 0;
        for (Integer n : bSet)
        {
            if(!aSet.contains(n))
                bCount++;
        }

        System.out.println(aCount+bCount);

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
