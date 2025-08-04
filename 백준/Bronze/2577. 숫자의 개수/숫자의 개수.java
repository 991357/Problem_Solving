import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String value = String.valueOf(a * b * c);

        int numArr[] = new int[10];

        for (int i = 0; i < value.length(); i++)
            numArr[value.charAt(i) - '0'] += 1;

        for (int n : numArr)
            System.out.println(n);
    }
}
