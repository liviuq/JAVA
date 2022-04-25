package game;

import game.exceptions.BagNoItemsRemaining;

import java.util.List;

import static java.lang.Thread.sleep;

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

    public void setGame(Game game)
    {
        this.game = game;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private boolean submitWord() throws InterruptedException {
        StringBuilder word = new StringBuilder();
        List<Tile> extracted;
        try
        {
            extracted = game.getBag().extractTiles(5);
            if(extracted.isEmpty())
            {
                return false;
            }
            for( Tile tile : extracted)
            {
                word.append(tile.getLetter());
            }
        }
        catch (BagNoItemsRemaining e)
        {
            System.out.println("No more letters remaining in the bag.");
        }

        game.getBoard().addWord(this, word.toString());
        sleep(50);
        return true;
    }

    @Override
    public void run()
    {
        try {
            submitWord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
