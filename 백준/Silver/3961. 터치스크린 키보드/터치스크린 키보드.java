import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;

    static int[][] keyboardArr = new int[3][10];

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        // keyboard데이터 구성
        setKeyboard();

        for (int t = 0; t < T; t++) {
            String original = "";
            int n;
            List<Word> wordList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            original = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                wordList.add(new Word(str));
            }
            // 오리지널과 wordList들 비교해서 거리 계산하기
            for (int i = 0; i < wordList.size(); i++) {
                int dist = 0;

                for (int j = 0; j < original.length(); j++) {
                    // original.charAt(j) 의 위치와
                    // wordList.get(i).charAt(j) 의 위치
                    char oc = original.charAt(j);
                    char wc = wordList.get(i).str.charAt(j);

                    if (oc == wc) {
                        continue;
                    } else {
                        // 이 거리를 계산해서 더하고
                        int ocr = 0, occ = 0, wcr = 0, wcc = 0, cnt = 0;
                        K:
                        for (int k = 0; k < 3; k++) {
                            for (int l = 0; l < 10; l++) {
                                if (cnt == 2) {
                                    break K;
                                }
                                if (keyboardArr[k][l] == oc) {
                                    ocr = k;
                                    occ = l;
                                    cnt++;
                                } else if (keyboardArr[k][l] == wc) {
                                    wcr = k;
                                    wcc = l;
                                    cnt++;
                                }
                            }
                        }
                        dist += Math.abs(wcr - ocr) + Math.abs(wcc - occ);
                    }
                }

                wordList.get(i).dist = dist;
            }

            // 정렬
            Collections.sort(wordList, new Comparator<Word>() {
                @Override
                public int compare(Word o1, Word o2) {
                    if (o1.dist != o2.dist) {
                        return Integer.compare(o1.dist, o2.dist);
                    }
                    return o1.str.compareTo(o2.str);
                }
            });

            for (int i = 0; i < wordList.size(); i++) {
                sb.append(wordList.get(i).str).append(" ").append(wordList.get(i).dist)
                    .append("\n");
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        System.out.println(sb);
    }

    private static void setKeyboard() {
        String s1 = "qwertyuiop";
        for (int i = 0; i < s1.length(); i++) {
            keyboardArr[0][i] = s1.charAt(i);
        }

        String s2 = "asdfghjkl";
        for (int i = 0; i < s2.length(); i++) {
            keyboardArr[1][i] = s2.charAt(i);
        }

        String s3 = "zxcvbnm";
        for (int i = 0; i < s3.length(); i++) {
            keyboardArr[2][i] = s3.charAt(i);
        }
    }

    static class Word {

        String str;
        int dist;

        public Word(String str) {
            this.str = str;
        }
    }
}
