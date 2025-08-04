import java.io.*;
import java.util.*;

public class Main
{
    static class Person
    {
        int age, order;
        String name;
        Person(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();

        for (int i = 0; i < T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(age, i, name));
        }

        list.sort((p1, p2) ->
        {
            if (p1.age != p2.age) return Integer.compare(p1.age, p2.age);
            else return Integer.compare(p1.order, p2.order); // 입력 순서 유지
        });

        for (Person p : list)
            System.out.println(p.age + " " + p.name);
    }
}
