import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame
{
//    ConfigPanel configPanel;
//    ControlPanel controlPanel;
//    DrawingPanel canvas;

    public MainFrame()
    {
        super("A cool game we can play");
        init();
    }

    private void init()
    {
        //what happens when an user wants to "close" the app
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //creating the components
//        canvas = new DrawingPanel(this);
//        controlPanel = new ControlPanel(this);
//        configPanel = new ConfigPanel(this);
//
//        //arranging the components
//        add(canvas, "CENTER");

        pack();
    }
}
