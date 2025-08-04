import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int num = 1;

        StringBuilder temp = new StringBuilder();

        while (true)
        {
            temp.append(num); // num을 추가

            int turn = 0;

            for (int i = 0; i < temp.length(); i++)
            {
                if (temp.charAt(i) == number.charAt(turn))
                {
                    turn++;
                    
                    if (turn == number.length()) break;
                }
            }

            if (turn == number.length()) break;

            num++;
        }

        System.out.println(num);
    }
}
