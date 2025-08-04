import java.io.*;
import java.util.*;

public class Main
{
    public static class Pos
    {
        int x, y;

        Pos(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        List<Pos> posList = new ArrayList<>();

        for (int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Pos pos = new Pos(x,y);

            posList.add(pos);
        }

        posList.sort((p1, p2) ->
        {
            if (p1.y != p2.y) return Integer.compare(p1.y, p2.y);
            else return Integer.compare(p1.x, p2.x);
        });


        for (Pos pos : posList)
            System.out.println(pos.x + " " + pos.y);
    }
}
