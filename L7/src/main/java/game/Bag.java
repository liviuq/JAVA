package game;

import game.exceptions.BagNoItemsRemaining;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Bag
{
    private final Queue<Tile> letters;
    private final List<List<Character>> letterPoints;

    public Bag()
    {
        //instantiating slower butt thread-safe variant of a queue
        letters = new LinkedBlockingDeque<>();
        //instantiating points for letter
        letterPoints = new ArrayList<>();

        //adding points up to 10
        for(int i = 0; i <= 10; i++)
        {
            letterPoints.add(new LinkedList<>());
        }

        //adding letters into specific point pools
        letterPoints.get(1).addAll(Arrays.asList('A','E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R'));
        letterPoints.get(2).addAll(Arrays.asList('D','G'));
        letterPoints.get(3).addAll(Arrays.asList('B','C', 'M', 'P'));
        letterPoints.get(4).addAll(Arrays.asList('F', 'H', 'V', 'W', 'Y'));
        letterPoints.get(5).addAll(Arrays.asList('K'));
        letterPoints.get(8).addAll(Arrays.asList('J', 'X'));
        letterPoints.get(10).addAll(Arrays.asList('Q', 'Z'));

        //print the points
        //printPoints();

        //adding tiles to the bag using a CSV file
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new File("tilecount.csv"));
            scanner.useDelimiter(",");

            //assert that we have a valid scanner
            assert (scanner != null);

            //iterating through the file
            while (scanner.hasNext())
            {
                String pair = scanner.next();
                //System.out.printf("pair: %s, char: %c, points: %d", pair, pair.charAt(0), Character.getNumericValue(pair.charAt(2)));
                addLetterTimes(pair.charAt(0), Character.getNumericValue(pair.charAt(2)));
            }

            //cleaning up
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

        //print tiles
        //printTiles();
    }

    public void addLetterTimes(char letter, int times)
    {
        //how many points does the letter have
        int point = 0;

        //break out of the outer loop
        int stop = 0;

        //iterating through the points
        for (List<Character> letterPoint : letterPoints)
        {
            //check to see if this point contains the query letter
            for (Character thisChar : letterPoint)
            {
                if (thisChar.equals(letter))
                {
                    stop = 1;
                    break;
                }
            }
            if (stop == 1)
            {
                break;
            }
            point++;
        }
        for (int i = 0; i < times; i++)
        {
            letters.add(new Tile(letter, point));
        }
    }

    public synchronized List<Tile> extractTiles(int number) throws BagNoItemsRemaining
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

    public int getTilePoints(char letter)
    {
        int point = 0;
        for (List<Character> letterPoint : letterPoints)
        {
            for(Character thisChar : letterPoint)
            {
                if(thisChar.equals(letter))
                {
                    return point;
                }
            }
            point++;
        }

        //usually throw an exception
        return -1;
    }

    public void printPoints()
    {
        int point = 0;
        for (List<Character> letterPoint : letterPoints)
        {
            System.out.printf("(%d point) - ", point);
            for(Character thisChar : letterPoint)
            {
                System.out.printf("%c ", thisChar);

            }
            System.out.printf("\n");
            point++;
        }
    }

    public void printTiles()
    {
        for(Tile tile : letters)
        {
            System.out.printf("points: %d, letter: %c\n", tile.getPoints(), tile.getLetter());
        }
    }
}