import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken(), B = st.nextToken();
        String aTemp = "", bTemp = "";

        for (int i = A.length() - 1; i >= 0; i--)
            aTemp += A.charAt(i);

        for (int i = B.length() - 1; i >= 0; i--)
            bTemp += B.charAt(i);

        if(Integer.parseInt(aTemp) > Integer.parseInt(bTemp))
            System.out.println(aTemp);
        else
            System.out.println(bTemp);
    }
}