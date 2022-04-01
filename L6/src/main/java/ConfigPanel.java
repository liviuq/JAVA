import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel
{
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1, spinner2;
    JButton button;

    public ConfigPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        label = new JLabel("Settings for grid size");
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        button = new JButton("Generate");

        add(label);
        add(spinner1);
        add(spinner2);
        add(button);
    }
}
