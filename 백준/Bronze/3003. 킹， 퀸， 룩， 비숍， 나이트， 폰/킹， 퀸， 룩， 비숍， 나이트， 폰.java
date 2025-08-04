import java.io.*;
import java.util.StringTokenizer;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numArr[] = new int[6];
        int needArr[] = {1,1,2,2,2,8};

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <numArr.length; i++)
            sb.append(needArr[i] - numArr[i]).append(" ");

        System.out.println(sb);
    }
}
