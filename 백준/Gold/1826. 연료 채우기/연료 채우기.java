import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class GasStation {
        int dist, oil;

        public GasStation(int dist, int oil) {
            this.dist = dist;
            this.oil = oil;
        }
    }

    static int N, L, P;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        GasStation[] gasStationArr = new GasStation[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gasStationArr[i] = new GasStation(a, b);
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 지금 내가 L 만큼 가야되는데 P 만큼의 연료가 있다.
        // 내 위치로부터 gasStationArr[i].dist 만큼의 떨어진 거리에 gasStationArr[i].oil 만큼 채울 수 있는 주유소가 있다.
        // 최소한의 횟수로 서야한다. 마을까지 못가는 경우엔 -1을 출력하고, 갈 수 있다면 중간에 들리는 주유소의 횟수를 출력한다.

        // 일단 주유소를 거리순으로 정렬하고
        Arrays.sort(gasStationArr, (o1, o2) -> Integer.compare(o1.dist, o2.dist));

        int lastIdx = 0;
        int reach = P;
        int stopCnt = 0;

        PriorityQueue<GasStation> gasPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.oil, o1.oil));

        while (true) {
            while (lastIdx < N && gasStationArr[lastIdx].dist <= reach) {
                gasPq.offer(gasStationArr[lastIdx]);
                lastIdx++;
            }

            if(L <= reach) break;
            if(gasPq.isEmpty()) break;

            GasStation temp = gasPq.poll();
            reach += temp.oil;
            stopCnt++;
        }
        System.out.println(reach < L ? -1 : stopCnt);
    }
}