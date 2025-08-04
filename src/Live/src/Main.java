public class Main
{
    static class UserInfo
    {
        private static UserInfo I = new UserInfo();
        UserInfo(){};

        public UserInfo getI()
        {
            return I;
        }

        String name = "홍길동";

        @Override
        public String toString()
        {
            return "이름 : " + this.name;
        }
    }

    static class MemberInfo extends UserInfo
    {
        String grade = "정회원";

        @Override
        public String toString()
        {
            return super.toString() + ", 등급 : " + grade;
        }
    }

    static class SuperClass
    {
        String x = "Super";

        public void method()
        {
            System.out.println("super Class");
        }
    }

    static class subClass extends SuperClass
    {
        String x = "sub";

        @Override
        public void method()
        {
            System.out.println("sub Class");
        }
    }

    public static void main(String[] args)
    {
        Object member = new MemberInfo();
        System.out.println(member.toString());

        System.out.println(UserInfo.I.toString());
    }
}