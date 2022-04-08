package game.exceptions;

public class BagNoItemsRemaining extends Exception
{
    public BagNoItemsRemaining(String errorMessage)
    {
        super(errorMessage);
    }
}
