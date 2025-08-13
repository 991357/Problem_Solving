import java.io.*;
import java.util.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int L, C;

    static char[] passWordArr;

    public static void main(String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        passWordArr = new char[C];

        st = new StringTokenizer(br.readLine());

        // 입력
        for( int i = 0; i < C; i++)
            passWordArr[i] = st.nextToken().charAt(0);

        // 정렬
        Arrays.sort(passWordArr);

        char[] sel = new char[L];
        Subset(sel, 0, 0);

        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }

    private static void Subset(char[] sel, int idx, int k)
    {
        if(k == L)
        {
            // 검증 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
            if(CheckSel(sel))
            {
                for(int i = 0; i < sel.length; i++)
                    sb.append(sel[i]);
                sb.append("\n");
            }
            return;
        }
        
        if(idx == C) return;

        sel[k] = passWordArr[idx];
        Subset(sel, idx + 1, k + 1);
        Subset(sel, idx + 1, k);
    }

    private static boolean CheckSel(char[] sel)
    {
        int vowelCount = 0, consonantCont = 0;

        for(int i = 0; i < sel.length; i++)
        {
            if(sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' || sel[i] == 'o' || sel[i] == 'u')
                vowelCount++;
            else
                consonantCont++;
        }

        if(vowelCount >= 1 && consonantCont >= 2)
            return true;
        else
            return false;
    }
}