import java.io.*;
import java.util.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String str = br.readLine();

            if (str.charAt(0) == '0' && str.length() == 1)
                break;

            String[] tempArr = str.split(" ");

            String start = "";
            for(int j = 0; j < tempArr[0].length(); j++)
                start += tempArr[0].charAt(j) - '0';

            int arr[] = new int[Integer.parseInt(start)];

            for (int i = 1; i < tempArr.length; i++)
            {
                String num = "";

                for(int j = 0; j < tempArr[i].length(); j++)
                    num += tempArr[i].charAt(j) - '0';

                arr[i - 1] = Integer.parseInt(num);
            }

            Arrays.sort(arr);

            boolean[] checkArr = new boolean[arr.length];
            int[] sel = new int[6];

            recursive(arr, sel, checkArr, 0, 0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int[] arr, int[] sel,boolean[] checkArr, int depth, int idx, int l)
    {
        // b
        if (idx == sel.length)
        {
            for(int i = 0; i < sel.length; i++)
                sb.append(sel[i] + " ");

            sb.append("\n");

            return;
        }

        if(depth == arr.length) return;

        // i
        for(int i = l; i < arr.length; i++)
        {
            if(!checkArr[i])
            {
                checkArr[i] = true;
                sel[idx] = arr[i];
                recursive(arr, sel, checkArr, depth + 1, idx + 1, i + 1);
                checkArr[i] = false;
            }
        }
    }
}

