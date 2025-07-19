import java.io.*;
import java.util.*;

public class RecursiveFunction_250719
{
    public static int count;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        count = N;

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        RecursiveFunction(N);

        System.out.println(sb);

        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
        // 백준 제출할 때 클래스 명 바꾸세요
    }

    public static void RecursiveFunction(int n)
    {
        String underline = "____".repeat(count - n);

        if(n == 0)
        {
            sb.append(underline + "\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(underline + "\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
        }
        else
        {
            sb.append(underline + "\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(underline + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" + underline +
                    "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" + underline +
                    "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
            RecursiveFunction(n-1);
        }
        sb.append(underline + "라고 답변하였지.").append("\n");
    }

}
