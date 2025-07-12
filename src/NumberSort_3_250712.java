import java.io.*;

public class NumberSort_3_250712
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] countArr = new int[T];

        for (int i = 0; i < T; i++)
        {
            int temp = Integer.parseInt(br.readLine());
            countArr[temp]++;
        }

        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < countArr[i]; j++)
                bw.write(i + "\n");
        }

        bw.flush();
    }
}
