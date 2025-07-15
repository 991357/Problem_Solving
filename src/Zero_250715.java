import java.io.*;
import java.util.*;

public class Zero_250715
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Stack<Integer> numberStack = new Stack<>();

        for (int i = 0; i < T; i++)
        {
            int temp = Integer.parseInt(br.readLine());

            if(temp == 0)
                numberStack.pop();
            else
                numberStack.push(temp);
        }

        int sum = 0;
        for (int n : numberStack)
            sum += n;
        System.out.println(sum);


        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }
}
