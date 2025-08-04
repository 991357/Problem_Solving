import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();

        ArrayList<Character> tempList = new ArrayList<>();

        for (int i = 0; i < temp.length(); i++)
            tempList.add(temp.charAt(i));

        tempList.sort(Collections.reverseOrder());

        String palindrome = "";
        ArrayList<Character> palindromeList = new ArrayList<>();

        int turn = 0;

        while (turn != tempList.size() - 1)
        {
            if(tempList.isEmpty())
                break;

            if(tempList.get(turn) == tempList.get(turn+1))
            {
                palindromeList.add(0, tempList.get(turn));
                palindromeList.add(tempList.get(turn+1));

                tempList.remove(turn);
                tempList.remove(turn);

                turn = -1;
            }
            turn++;
        }

        if(!tempList.isEmpty())
        {
            int middle = palindromeList.size() / 2;
            palindromeList.add(middle, tempList.get(0));
        }

        if(palindromeList.size() == temp.length())
        {
            for (Character c : palindromeList)
                System.out.print(c);
        }
        else
            System.out.println("I'm Sorry Hansoo");
    }
}
