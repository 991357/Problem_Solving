public interface IBookManager
{
    public void add(Book b);

    public void remove(String isbn);

    public Book[] getList();

    public Book[] searchByIsbn(String isbn);

    public Book[] searchByTitle(String title);

    public Magazine[] getMagazines();

    public Book[] getBooks();

    public int getTotalPrice();

    public double getPriceAvg();
}
