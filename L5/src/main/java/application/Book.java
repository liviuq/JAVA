package application;

import java.util.Objects;

public class Book extends Item
{
    private int numberOfPages;

    public Book(String id, String title, String location, int numberOfPages)
    {
        super(id, title, location);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages()
    {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages)
    {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), numberOfPages);
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                '}';
    }
}
