public class Son extends Father implements Mother
{
    @Override
    public void work()
    {
        super.work();
    }

    public void work(String q)
    {
        System.out.println("안녕");
    }
}
