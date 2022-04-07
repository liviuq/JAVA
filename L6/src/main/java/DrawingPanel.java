import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DrawingPanel extends JPanel
{
    private final MainFrame frame;

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

        //EDIT
        frame.configPanel.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init(frame.configPanel.getRows(), frame.configPanel.getCols());
                frame.canvas.revalidate();
                frame.canvas.repaint();
            }
        });
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
        //paintStones(g);
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

        //EDIT
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
                        }
                    }
                }
            }
        }
    }
}
