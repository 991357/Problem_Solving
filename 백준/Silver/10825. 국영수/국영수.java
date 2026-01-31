import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Student {
        String name;
        int kor, eng, mat;

        public Student(String name, int kor, int eng, int mat) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        List<Student> stuList = new ArrayList<>();

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());

            stuList.add(new Student(name, kor, eng, mat));
        }

        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.kor != o2.kor) {
                    return Integer.compare(o2.kor, o1.kor);
                }
                if (o1.eng != o2.eng) {
                    return Integer.compare(o1.eng, o2.eng);
                }
                if (o1.mat != o2.mat) {
                    return Integer.compare(o2.mat, o1.mat);
                }
                return o1.name.compareTo(o2.name);
            }
        });

        for(Student stu : stuList) {
            sb.append(stu.name).append("\n");
        }

        if(sb.length() > 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
    }
}