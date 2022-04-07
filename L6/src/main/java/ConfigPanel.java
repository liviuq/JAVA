import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel
{
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1, spinner2;
    JButton button;
    JButton saveAsPNG;

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

        //EDIT
        button = new JButton("Generate");
        saveAsPNG = new JButton("Save as PNG");

        add(label);
        add(spinner1);
        add(spinner2);
        add(button);
        add(saveAsPNG);
    }

    public int getRows()
    {
        return (Integer)spinner1.getValue();
    }

    public int getCols()
    {
        return (Integer)spinner2.getValue();
    }
}
