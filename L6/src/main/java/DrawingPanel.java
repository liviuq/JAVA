import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.sqrt;

public class DrawingPanel extends JPanel implements Serializable
{
    private final MainFrame frame;

    private Set<Point> knownLocations = new HashSet<>();
    private Set<Point> markedLocations = new HashSet<>();

    boolean color = false; //false - red, true - blue
    int rows, cols;
    int canvasWidth = 600, canvasHeight = 600;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;

    public DrawingPanel(MainFrame frame)
    {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());

        frame.configPanel.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init(frame.configPanel.getRows(), frame.configPanel.getCols());

                //once we generate a new table, wipe previous marked positions
                getMarkedLocations().clear();

                frame.canvas.revalidate();
                frame.canvas.repaint();
            }
        });

        frame.configPanel.saveAsPNG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                printAll(g);
                try
                {
                    ImageIO.write(image, "png", new File("picture.png"));
                }
                catch (IOException exception)
                {
                    exception.printStackTrace();
                }
            }
        });

        addMouseListener(
                new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        Point point = getClosestPointTo(e.getPoint());

                        //if the desired location is valid(i.e. vertex
                        //is adjacent with at least one edge
                        if(!getMarkedLocations().contains(point))
                        {
                            if(getKnownLocations().contains(point))
                            {
                                //swap color
                                getMarkedLocations().add(point);
                                Graphics2D g = (Graphics2D) getGraphics();

                                if(color)
                                {
                                    g.setColor(Color.BLUE);
                                }
                                else
                                {
                                    g.setColor(Color.RED);
                                }
                                color = !color;

                                g.setStroke(new BasicStroke(10));
                                g.drawOval(point.x - stoneSize / 2, point.y - stoneSize / 2, stoneSize, stoneSize);
                            }
                        }
                    }
                }
        );
    }

    final void init(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);

        //stone painting is done in the mouse handler
        //paintStones(g);
    }

    public Set<Point> getKnownLocations()
    {
        return knownLocations;
    }

    public Set<Point> getMarkedLocations()
    {
        return markedLocations;
    }

    private void paintGrid(Graphics2D g)
    {
        g.setColor(Color.DARK_GRAY);

        //horizontal lines
        for (int row = 0; row < rows; row++)
        {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }

        //vertical lines
        for (int col = 0; col < cols; col++)
        {
            int x1 = padY;
            int y1 = padX + col * cellWidth;
            int x2 = padY + boardHeight;
            int y2 = y1;

            g.drawLine(y1, x1,y2,x2);
        }

        //intersections
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private void paintSticks(Graphics2D g)
    {
        Random rand = new Random();
        double probability = 0.5;
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(10));

        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                for(int dx = 0; dx < 2; dx++)
                {
                    for(int dy = 0; dy < 2; dy++)
                    {
                        if(dx == dy || row + dy >= rows || col + dx >= cols)
                        {
                            continue;
                        }

                        if(rand.nextDouble() < probability)
                        {
                            int x1 = padX + col * cellWidth;
                            int y1 = padY + row * cellHeight;
                            int x2 = x1 + dx * cellWidth;
                            int y2 = y1 + dy * cellHeight;
                            g.drawLine(x1, y1, x2, y2);
                            knownLocations.add(new Point(x1, y1));
                            knownLocations.add(new Point(x2, y2));
                            System.out.printf("Point: %d %d\n", x1/cellWidth, y1/cellHeight);
                        }
                    }
                }
            }
        }
    }

    public Point getClosestPointTo(Point point)
    {
        Point ret = new Point(0,0);
        double minDistance = canvasWidth;
        double temporaryDistance;
        for(Point knownPoint : knownLocations)
        {
            temporaryDistance = sqrt((knownPoint.x - point.x)*(knownPoint.x - point.x) + (knownPoint.y - point.y)*(knownPoint.y - point.y));
            if(temporaryDistance < minDistance)
            {
                minDistance = temporaryDistance;
                ret = knownPoint;
            }
        }
        return ret;
    }
}
