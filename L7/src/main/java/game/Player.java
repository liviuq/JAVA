package game;

import game.exceptions.BagNoItemsRemaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Player implements Runnable
{
    private String name;
    private int id;
    private int points;
    private List<Tile> tiles;
    private Game game;

    public Player(String name, int id)
    {
        this.name = name;
        this.id = id;
        this.points = 0;

        this.tiles = new ArrayList<>();

        //draw 7 tiles
        try
        {
            //wait
            while(game == null);
            tiles.addAll(game.getBag().extractTiles(7));
        }
        catch (BagNoItemsRemaining e)
        {
            System.out.println("No tiles remaining");
        }
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

    public void drawTiles(int numberOfNewTiles)
    {
        try
        {
            tiles.addAll(game.getBag().extractTiles(numberOfNewTiles));
        }
        catch (BagNoItemsRemaining e)
        {
            System.out.println("No tiles remaining");
        }
    }

    private boolean submitWord() throws InterruptedException
    {
        StringBuilder word = new StringBuilder();

        //create a word based on your available tiles

        //if not, discard your letters and draw 7 new ones


        //check to see if word exists
        if(game.getDictionary().isWord(word.toString()))
        {
            //submit word
            game.getBoard().addWord(this, word.toString());

            //calculate and update player score
            for(int i = 0; i < word.length(); i++)
            {
                this.points += (game.getBag().getTilePoints(word.charAt(i))) * word.length();
            }

            //draw remainig tiles
            try
            {
                tiles.addAll(game.getBag().extractTiles(word.length()));
            }
            catch (BagNoItemsRemaining e)
            {
                System.out.println("No tiles remaining");
            }
        }

        sleep(50);
        return true;
    }

    @Override
    public void run()
    {
        try {
            if(!submitWord())
            {
                System.out.println("Empty bag");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
