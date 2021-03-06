package application;

import application.exception.InvalidCatalogException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Paths;

public class CatalogUtil
{
    public static void save(Catalog catalog, String path)
                            throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

        objectWriter.writeValue(
                Paths.get(path).toFile(),
                catalog
        );
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class
        );

        return catalog;
    }
}
