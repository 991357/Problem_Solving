import java.io.*;
import java.util.*;

// 부분 집합
public class Recursive04
{
    // 원본
    static int[] arr = {1,3,5};

    // 선택  1 -> sel[0], sel[1] 1 => .....
    static boolean[] sel = new boolean[arr.length];

    public static void main(String[] args)
    {
        recursive(0);
    }

    private static void recursive(int idx)
    {
        // bases part
        if(idx == arr.length)
        {
            for(int i = 0; i < sel.length; i++)
            {
                if(sel[i])
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // inductive part
        else
        {
            // 선택하는 경우
            sel[idx] = true;
            recursive(idx + 1);

            // 선택하지 않는 경우
            sel[idx] = false;
            recursive(idx + 1);
        }
    }
}
