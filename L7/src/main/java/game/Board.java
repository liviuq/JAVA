package game;

import java.util.HashSet;
import java.util.Set;

public class Board
{
   private final Set<String> words;

    public Board()
    {
        this.words = new HashSet<>();
    }

    public synchronized void addWord(Player player, String word)
   {
       words.add(word);
   }

    @Override
    public String toString() {
        return "Board{" +
                "words=" + words +
                '}';
    }
}
