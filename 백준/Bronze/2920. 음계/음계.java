import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ascending[] = {1,2,3,4,5,6,7,8};
        int descending[] = {8,7,6,5,4,3,2,1};

        int numArr[] = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        if(Arrays.equals(numArr, ascending))
            System.out.println("ascending");
        else if(Arrays.equals(numArr, descending))
            System.out.println("descending");
        else
            System.out.println("mixed");
    }
}
