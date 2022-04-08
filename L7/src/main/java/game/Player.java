package game;

import game.exceptions.BagNoItemsRemaining;

import java.util.List;

public class Player implements Runnable
{
    private String name;
    private int id;
    private Game game;

    public Player(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    private boolean submitWord()
    {
        try
        {
            List<Tile> extracted = game.getBag().extractTiles(7);
            if(extracted.isEmpty())
            {
                return false;
            }
        }
        catch (BagNoItemsRemaining e)
        {
            e.printStackTrace();
        }

        

        game.getBoard().addWord(this, word);
        return true;
    }

    @Override
    public void run()
    {

    }
}
