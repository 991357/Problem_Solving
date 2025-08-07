import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> numStack = new Stack<>();

        int num = 0, prev = 0;

        StringBuilder sb = new StringBuilder();

        int numArr[] = new int[N];
        for(int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(br.readLine());

        int saveArr[] = new int[N];
        int saveNum = 0;

        for(int i = 0; i < N; i++)
        {
            if(numArr[i] >= prev)
            {
                for(int j = prev; j < numArr[i]; j++) // 입력까지 스택에 넣기
                {
                    if(num + 1 <= numArr[i])
                    {
                        num++;
                        numStack.push(num);
                        sb.append("+").append("\n");
                    }
                }

                sb.append("-").append("\n"); // 넣은거에 최상위 빼기
                saveArr[saveNum] =numStack.pop();
                saveNum++;

                prev = numArr[i];
            }
            else
            {
                for(int j = prev; j > numArr[i]; j--)
                {
                    if(numStack.size() != 0 && numArr[i] == numStack.peek())
                    {
                        saveArr[saveNum] = numStack.pop();
                        saveNum++;
                        sb.append("-").append("\n");
                    }
                }
                prev = numArr[i] + 1;
            }
        }
        if(Arrays.equals(saveArr, numArr))
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}