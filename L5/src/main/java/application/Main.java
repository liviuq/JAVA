package application;

import application.exception.InvalidCatalogException;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws InvalidCatalogException, IOException {
        Catalog books = new Catalog("My favourite books");

        Item book1 = new Book("981245", "Quiet", "i guess it s home", 244);

        try
        {
            books.add(book1);
        }
        catch (InvalidCatalogException e)
        {
            System.out.println(e);
        }

        CatalogUtil.save(books, "/home/family/Documents/JAVA/L5/ceau.txt");
    }
}
