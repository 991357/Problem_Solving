import java.io.*;
import java.util.*;

public class test
{
    static class Person {
        String name;
        int age;

        Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args)
    {
        String str = "Hi";
        str.replace(str.charAt(1), 'e');
        System.out.println(str);

    }
}
