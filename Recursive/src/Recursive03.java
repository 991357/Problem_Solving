import java.io.*;
import java.util.*;

/*
* arr에서 2개만 조합해주세요!
*/

// 조합
public class Recursive03
{
    // 원본
    static int arr[] = {1,3,5};

    // 몇개?
    static int N = 2;

    // 선택
    static int sel[] = new int[N];

    public static void main(String[] args)
    {
        recursive(0, 0);
    }

    private static void recursive(int idx, int k)
    {
        // bases part
        if(k == N)
        {
            System.out.println(Arrays.toString(sel));
            return;
        }
        if(idx == arr.length) return;

        // inductive part
        else
        {
            // 선택하는 경우
            sel[k] = arr[idx];
            recursive(idx + 1, k + 1);

            // 선택하지 않는 경우
            recursive(idx + 1, k);
        }
    }
}
