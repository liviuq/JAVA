package application.exception;

public class ItemNotFoundCatalogException extends Exception
{
    public ItemNotFoundCatalogException(Exception exception)
    {
        super("Item not found.", exception);
    }
}

