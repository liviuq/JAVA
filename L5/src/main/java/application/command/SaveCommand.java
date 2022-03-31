package application.command;

import application.Catalog;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;

public abstract class SaveCommand
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
}
