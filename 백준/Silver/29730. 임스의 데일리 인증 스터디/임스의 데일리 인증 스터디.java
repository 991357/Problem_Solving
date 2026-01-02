import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException
    {
        N = Integer.parseInt(br.readLine());
        List<String> studyList = new ArrayList<String>();
        List<String> bojList = new ArrayList<String>();
        
        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            boolean isBoj = CheckBoj(temp);
            
            if(isBoj)
                bojList.add(temp);
            else
                studyList.add(temp);
        }
        
        Collections.sort(studyList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return Integer.compare(s1.length(), s2.length());
            }
        });
        
        Collections.sort(bojList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int num1 = Integer.parseInt(s1.substring(7));
                int num2 = Integer.parseInt(s2.substring(7));
                
                return Integer.compare(num1, num2);
            }
        });
        
        for(int i = 0; i < studyList.size(); i++)
            sb.append(studyList.get(i)).append("\n");
        
        for(int i = 0; i < bojList.size(); i++)
            sb.append(bojList.get(i)).append("\n");
        
        System.out.println(sb);
    }
    
    static boolean CheckBoj(String temp) {
        if(temp.length() > 7 && temp.startsWith("boj.kr/")) {
            return true;
        }
        return false;
    }
}