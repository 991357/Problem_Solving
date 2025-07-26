public class Magazine extends Book
{
    int year;
    int month;

    Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month)
    {
        super(isbn, title, author, publisher, price, desc);
        this.year = year;
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public String toString()
    {
        return isbn + " | " + title + " | " + author + " | " + publisher + " | " + price + " | " + desc + " | " + year + " | " + month;
    }
}
