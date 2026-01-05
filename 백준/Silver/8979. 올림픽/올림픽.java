import java.io.*;
import java.util.*;

class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static class country 
    {
        int num, gold, silver, bronze, rank;

        public country(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<country> countryList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            countryList.add(new country(n, g, s, b));
        }

        Collections.sort(countryList, new Comparator<country>() {
            @Override
            public int compare(country a, country b) {
                if(a.gold == b.gold) {
                    if(a.silver == b.silver) {
                        if(a.bronze == b.bronze)
                            return Integer.compare(a.num, b.num);
                        else
                            return Integer.compare(b.bronze, a.bronze);
                    }
                    else
                        return Integer.compare(b.silver, a.silver);
                }
                return Integer.compare(b.gold, a.gold);
            }
        });

        // 순위 매기기
        int curRank = 1, temp = 0;
        for(int i = 0; i < countryList.size(); i++) {
            // 현재 랭크 넣고
            countryList.get(i).rank = curRank;

            if(i == countryList.size() - 1)
            {
                countryList.get(i).rank = curRank;
                break;
            }

            if(countryList.get(i).gold == countryList.get(i+1).gold && 
            countryList.get(i).silver == countryList.get(i+1).silver && 
            countryList.get(i).bronze == countryList.get(i+1).bronze )
            {
                temp++;
            }
            else
            {
                if(temp == 0)
                    curRank++;
                else
                    curRank += temp;

                temp = 0;
            }
        }

        // K 찾기
        for(int i = 0; i < countryList.size(); i++) {
            if(countryList.get(i).num == K) {
                System.out.println(countryList.get(i).rank);
                return;
            }
        }
    }
}