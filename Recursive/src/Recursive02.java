import java.io.*;
import java.util.*;

/*
* {1,1,1} 싫어요
* {1,3,5} 좋아요
* ...
* ...
* {5,3,1} 좋아요
*/

// 중복 허용 X 순열
public class Recursive02
{
    // 원본
    static int[] arr = {1,3,5};

    // (중복을 허용하지 마세요!) 선택  1 -> sel[0], sel[1] 1 => .....
    static int[] sel = new int[arr.length];

    static boolean[] v = new boolean[arr.length];

    public static void main(String[] args)
    {
        recursive(0);
    }

    private static void recursive(int idx)
    {
        // bases part
        if(idx == arr.length)
        {
            System.out.println(Arrays.toString(sel));
            return;
        }

        // inductive part
        else
        {
            for(int i = 0; i < arr.length; i++)
            {
                if(!v[i])
                {
                    v[i] = true;
                    sel[idx] = arr[i];
                    recursive(idx+1);
                    v[i] = false;
                }
            }
        }
    }
}
