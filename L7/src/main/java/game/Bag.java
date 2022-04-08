package game;

import game.exceptions.BagNoItemsRemaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Bag
{
    private final Queue<Tile> letters;

    public Bag()
    {
        //declaring a random number generator
        Random generator = new Random();

        letters = new LinkedBlockingDeque<>();
        for( char c = 'a'; c <= 'z'; c++)
        {
            letters.add(new Tile(c, generator.nextInt(10)));
        }
    }

    public List<Tile> extractTiles(int number) throws BagNoItemsRemaining
    {
        //creating a list of the to-be-extracted tiles
        List<Tile> extracted = new ArrayList<>();

        //extracting
        for(int counter = 0; counter < number; counter++)
        {
            //checking to see if we have some tiles in the bag
            if(letters.isEmpty())
            {
                throw new BagNoItemsRemaining("No tiles remainig");
            }
            extracted.add(letters.remove());
        }

        return extracted;
    }
}
