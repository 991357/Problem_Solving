import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Stack<Integer> numStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1)
                numStack.push(Integer.parseInt(st.nextToken()));
            else if (type == 2)
            {
                if (numStack.size() == 0)
                    sb.append(-1).append("\n");
                else
                    sb.append(numStack.pop()).append("\n");
            }
            else if (type == 3)
            {
                sb.append(numStack.size()).append("\n");
            }
            else if (type == 4)
            {
                if (numStack.size() == 0)
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            else if (type == 5)
            {
                if (numStack.size() == 0)
                    sb.append(-1).append("\n");
                else
                    sb.append(numStack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
