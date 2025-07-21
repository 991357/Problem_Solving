import java.io.*;
import java.util.*;

public class PhoneNumber_250722
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution sl = new Solution();
        String temp[] = new String[]{"12345", "234"};
        System.out.println(sl.solution(temp));
    }

    static class Solution
    {
        public boolean solution(String[] phone_book)
        {
            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length - 1; i++)
            {
                if (phone_book[i + 1].startsWith(phone_book[i]))
                    return false;
            }

            return true;
        }
    }
}
