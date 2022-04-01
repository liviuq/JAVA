import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel
{
    final MainFrame frame;
    JButton exit;
    JButton load;
    JButton save;

    public ControlPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        exit = new JButton("GET ME OUT OF HERE");
        load = new JButton("Load");
        save = new JButton("Save");

        setLayout(new GridLayout(1,4));
        add(exit);
        add(load);
        add(save);

        exit.addActionListener(this::exitGame);
        load.addActionListener(this::load);
        save.addActionListener(this::save);
    }

    private void save(ActionEvent actionEvent)
    {
        System.out.println("Ought to be implemented");
    }

    private void load(ActionEvent actionEvent)
    {
        System.out.println("Ought to be implemented");
    }

    private void exitGame(ActionEvent actionEvent)
    {
        frame.dispose();
    }

}
