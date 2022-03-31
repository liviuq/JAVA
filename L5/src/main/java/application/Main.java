package application;

import application.command.*;
import application.exception.InvalidCatalogException;
import freemarker.template.TemplateException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws InvalidCatalogException, IOException, TemplateException
    {
        Catalog books = new Catalog("My favourite books");

        Item book1 = new Book("981245", "Quiet", "i guess it s home", 244);
        Item book2 = new Book("23445", "Loud", "home", 122);

        try
        {
            AddCommand.add(books, book1);
            AddCommand.add(books, book2);
        }
        catch (InvalidCatalogException e)
        {
            System.out.println(e);
        }

        try
        {
            SaveCommand.save(books, "catalog.json");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        try
        {
            Catalog test = LoadCommand.load("catalog.json");
            System.out.println("----------------");
            System.out.println(test);
        }
        catch (InvalidCatalogException e)
        {
            System.out.println("Invalid file catalog provided");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        //creating the report
        ReportCommand.report(books);

        //the metadata from the html file

        try
        {
            Metadata metadata = InfoCommand.info("web/output.html");

            //printing the metadata
            System.out.printf("%s\n%s\n",
                    metadata.get("X-Parsed-By"),
                    metadata.get("Author"));
        }
        catch (SAXException | TikaException e)
        {
            System.out.println(e);
        }


    }
}
