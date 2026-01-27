import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, H , W;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        String[] strArr = new String[H];

        for(int i = 0; i < H; i++) {
            strArr[i] = br.readLine();
        }

        StringBuilder tempSb = new StringBuilder();
        tempSb.append(strArr[0]);
        for(int i = 1; i < H; i++) {
            for(int j = 0; j < strArr[i].length(); j++) {
                if(strArr[i].charAt(j) != '?' && tempSb.charAt(j) == '?') {
                    tempSb.replace(j, j+1, String.valueOf(strArr[i].charAt(j)));
                }
            }
        }

        for(int i = 0; i < tempSb.length(); i += W) {
            boolean isCon = false;
            for(int j = i; j < W+i; j++) {
                if(isCon)
                    break;
                if(tempSb.charAt(j) != '?') {
                    sb.append(tempSb.charAt(j));
                    isCon = true;
                }
            }
            if(!isCon)
                sb.append("?");
        }
        System.out.println(sb);
    }
}