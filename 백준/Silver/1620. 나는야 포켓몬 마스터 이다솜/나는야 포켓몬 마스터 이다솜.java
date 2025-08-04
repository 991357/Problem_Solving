import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
  
        String[] pokemonList = new String[N+1];

        HashMap<String, Integer> pokemonMap = new HashMap<>();

        for (int i = 1; i <= N; i++)
        {
            String temp = br.readLine();
            pokemonList[i] = temp;
            pokemonMap.put(temp, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++)
        {
            String temp = br.readLine();

            if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9')
            {
                int n = Integer.parseInt(temp);
                sb.append(pokemonList[n]).append('\n');
            }
            else 
            {
                sb.append(pokemonMap.get(temp)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
