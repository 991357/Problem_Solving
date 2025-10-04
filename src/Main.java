import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L;

    static class TrafficLight
    {
        int d, r, g;
        int time;
        boolean isRed;

        public TrafficLight(int d, int r, int g)
        {
            this.d = d;
            this.r = r;
            this.g = g;
            time = 0;
            isRed = true;
        }

        public void flow()
        {
            time++;

            if(isRed && time >= r)
            {
                isRed = false;
                time = 0;
            }
            else if(!isRed && time >= g)
            {
                isRed = true;
                time = 0;
            }
        }
    }

    static TrafficLight[] trafficLightArr;
    static int myPos, realTime;
    static boolean[] trafficPosArr;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        myPos = 0;
        realTime = 0;

        trafficPosArr = new boolean[L];
        trafficLightArr = new TrafficLight[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            trafficPosArr[d] = true;
            trafficLightArr[i] = new TrafficLight(d, r, g);
        }

        int trafficTurn = 0;

        while(true)
        {
            if(trafficPosArr[myPos])
            {
                if(trafficLightArr[trafficTurn].isRed)
                    realTime++;
                else
                {
                    myPos++;
                    realTime++;
                    trafficTurn++;
                }
            }
            else
            {
                myPos++;
                realTime++;
            }

            for (int i = 0; i < N; i++)
                trafficLightArr[i].flow();

            if(myPos == L)
                break;
        }

        System.out.println(realTime);
    }
}