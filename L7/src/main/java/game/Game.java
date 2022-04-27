package game;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private final Bag bag;
    private final Board board;
    private final Dictionary dictionary;
    private final List<Player> players;

    public Game()
    {
        bag = new Bag();
        board = new Board();
        players = new ArrayList<>();
        dictionary = new Dictionary();
    }

    public void addPlayer(Player player)
    {
        players.add(player);
        player.setGame(this);
    }

    public void play()
    {
        for(Player player : players)
        {
            //start a new thread
            new Thread(player).start();
        }
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.addPlayer(new Player("p1", 1));
        game.addPlayer(new Player("p2", 2));
        game.addPlayer(new Player("p3", 3));
        game.addPlayer(new Player("p4", 4));

        game.play();
    }

    public Bag getBag()
    {
        return this.bag;
    }

    public Board getBoard()
    {
        return this.board;
    }

    public Dictionary getDictionary()
    {
        return this.dictionary;
    }
}
