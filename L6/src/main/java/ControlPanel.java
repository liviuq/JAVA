import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Paths;

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
        //EDIT
        exit = new JButton("GET ME OUT OF HERE");
        load = new JButton("Load");
        save = new JButton("Save");

        setLayout(new GridLayout(1,4));
        add(exit);
        add(load);
        add(save);

        //EDIT
        exit.addActionListener(this::exitGame);
        load.addActionListener(this::load);
        save.addActionListener(this::save);
    }

    //EDIT
    private void save(ActionEvent actionEvent)
    {
        System.out.println("[Saving...]");

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

//        try
//        {
//            objectWriter.writeValue(
//                    Paths.get("save").toFile(),
//                    frame.canvas
//            );
//        }
//        catch (StreamWriteException e) {
//            e.printStackTrace();
//        } catch (DatabindException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("[Saved!]");
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
