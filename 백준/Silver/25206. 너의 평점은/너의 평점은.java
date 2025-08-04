import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0, gradeTotal = 0;

        for (int i = 0; i < 20; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String title = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String gradeStr = st.nextToken();
            double grade = getGrade(gradeStr);

            if(!gradeStr.equals("P"))
            {
                totalScore += score * grade;
                gradeTotal += score;
            }
        }

        if(totalScore == 0.0 && gradeTotal == 0.0)
            System.out.println(0.0);
        else
            System.out.println(totalScore / gradeTotal);
    }

    static double getGrade(String grade)
    {
        if(grade.equals("A+"))
            return 4.5;
        else if(grade.equals("A0"))
            return 4.0;
        else if(grade.equals("B+"))
            return 3.5;
        else if(grade.equals("B0"))
            return 3.0;
        else if(grade.equals("C+"))
            return 2.5;
        else if(grade.equals("C0"))
            return 2.0;
        else if(grade.equals("D+"))
            return 1.5;
        else if(grade.equals("D0"))
            return 1.0;
        else
            return 0.0;
    }
}
