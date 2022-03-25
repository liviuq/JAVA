package application.exception;

public class InvalidCatalogException extends Exception
{
    public InvalidCatalogException(Exception exception)
    {
        super("Uninitialised catalog.", exception);
    }
}
