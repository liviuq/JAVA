import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame
{
    ConfigPanel configPanel = new ConfigPanel(this);
    ControlPanel controlPanel = new ControlPanel(this);
    DrawingPanel canvas = new DrawingPanel(this);

    public MainFrame()
    {
        super("A cool game we can play");
        init();
    }

    private void init()
    {
        //what happens when an user wants to "close" the app
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //arranging the components
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }
}
