package Supplementary;

import java.io.*;
import java.util.*;

public class CareFilm {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static  StringTokenizer st ;

    static int T, D, W, K;
    static int[][] map;

    static int min;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map= new int[D][W];

            for(int d = 0; d < D; d++){
                st = new StringTokenizer(br.readLine());
                for(int w = 0; w < W; w++){
                    map[d][w] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            dfs(0, new int[D], 0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    /// row -> 문제의 크기
    /// status -> 약물을 투입한 상태
    /// inject 약물 투입 횟수
    static void dfs(int row, int[] status, int inject){
        if(inject > min)
            return;

        // bases part
        if(row == D){
            // 강도 췤
            if(PressCheck(status)){
                min = Math.min(min, inject);
            }
            return;
        }

        // inductive part -> X부터 시도, A(0), B(1) 음.. 그럼 x를 -1로 해보자!
        for(int i = -1; i < 2; i++){ // i가 약물입니다.
            status[row] = i; // 약을 쳐
            if(i == -1){ // x는 약을 친게 아닌데?
                dfs(row + 1, status, inject);
            }else{
                dfs(row + 1, status, inject + 1);
            }
        }
    }

    // status[0] = -1 : 약을 안친것
    static boolean PressCheck(int[] status) {
        for (int w = 0; w < W; w++) {
            int base = -1;
            int k = 0;
            boolean pass = false;

            for (int d = 0; d < D; d++) {
                int target = (status[d] == -1) ? map[d][w] : status[d];

                if (d == 0) {
                    base = target;
                    k = 1;
                } else {
                    if (target == base) {
                        k++;
                    } else {
                        base = target;
                        k = 1;
                    }
                }

                if (k >= K) { // 해당 열 통과
                    pass = true;
                    break;
                }
            }

            if (!pass) return false; // 한 열이라도 실패하면 전체 실패
        }
        return true;
    }
}

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu