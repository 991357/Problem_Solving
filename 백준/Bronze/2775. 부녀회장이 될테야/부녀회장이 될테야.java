import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++)
        {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int roomArr[][] = new int[k+1][n];

            for (int i = 0; i <= k; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if(i == 0)
                        roomArr[i][j] = j+1;
                    else
                    {
                        if(j == 0)
                            roomArr[i][j] = 1;
                        else
                        {
                            for (int l = 0; l <= j; l++)
                                roomArr[i][j] += roomArr[i-1][l];
                        }
                    }
                }
            }

            System.out.println(roomArr[k][n-1]);
        }
    }
}
