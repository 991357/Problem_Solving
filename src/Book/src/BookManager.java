import java.util.*;

public class BookManager
{
    int MAX_SIZE = 10;
    Book books[];
    int size;

    public void add(Book b)
    {
        for	(int i = 0; i < MAX_SIZE; i++)
        {
            if(books[i] == null || books[i].isbn.isEmpty())
            {
                books[i] = b;
                break;
            }
        }
    }

    public void remove(String isbn)
    {
        for (Book book : books)
        {
            if(book.isbn.equals(isbn))
            {
                book = null;
                return;
            }
        }
    }

    public Book[] getList()
    {
        return books;
    }

    public Book[] searchByIsbn(String isbn)
    {
        ArrayList<Book> booksTemp = new ArrayList<>();

        for (Book book : books)
        {
            if(book.isbn.contains(isbn))
                booksTemp.add(book);
        }

        return booksTemp.toArray(new Book[0]);
    }

    public Book[] searchByTitle(String title)
    {
        ArrayList<Book> booksTemp = new ArrayList<>();

        for (Book book : books)
        {
            if(book == null)
                break;

            if(book.title.contains(title))
                booksTemp.add(book);
        }

        return booksTemp.toArray(new Book[0]);
    }

    public Magazine[] getMagazines()
    {
        ArrayList<Magazine> mags = new ArrayList<>();

        for (int i = 0; i < MAX_SIZE; i++)
        {
            if(books[i] == null)
                break;

            if (books[i] instanceof Magazine)
                mags.add((Magazine) books[i]);
        }

        return mags.toArray(new Magazine[0]);
    }

    public Book[] getBooks()
    {
        ArrayList<Book> bookList = new ArrayList<>();

        for (int i = 0; i < MAX_SIZE; i++)
        {
            if(books[i] == null)
                break;

            if (!(books[i] instanceof Magazine))
                bookList.add(books[i]);
        }

        return bookList.toArray(new Book[0]);
    }

    public int getTotalPrice()
    {
        int total = 0;

        for(Book book : books)
        {
            if(book == null)
                break;

            total += book.price;
        }

        return total;
    }

    public double getPriceAvg()
    {
        int total = getTotalPrice();

        int count = 0;

        for(Book book : books)
        {
            if(book == null)
                break;

            count++;
        }


        return (double)total / count;
    }

}
