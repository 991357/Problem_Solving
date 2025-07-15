import java.io.*;
import java.util.*;

public class Balanced_Diet_250715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String temp = br.readLine();

            if (temp.equals("."))
                break;

            Stack<Character> parenthesesStack = new Stack<Character>();
            Boolean isStop = false;

            for (int i = 0; i < temp.length(); i++)
            {
                if(temp.charAt(i) == '(')
                    parenthesesStack.push(temp.charAt(i));
                else if(temp.charAt(i) == '[')
                    parenthesesStack.push(temp.charAt(i));
                else if(temp.charAt(i) == ')')
                {
                    if(parenthesesStack.size() != 0)
                    {
                        if(parenthesesStack.peek() == '(')
                            parenthesesStack.pop();
                        else
                        {
                            isStop = true;
                            break;
                        }
                    }
                    else
                    {
                        isStop = true;
                        break;
                    }
                }
                else if(temp.charAt(i) == ']')
                {
                    if(parenthesesStack.size() != 0)
                    {
                        if(parenthesesStack.peek() == '[')
                            parenthesesStack.pop();
                        else
                        {
                            isStop = true;
                            break;
                        }
                    }
                    else
                    {
                        isStop = true;
                        break;
                    }
                }
            }

            if(isStop)
                System.out.println("no");
            else if(parenthesesStack.size() == 0)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
