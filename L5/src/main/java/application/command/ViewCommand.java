package application.command;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class ViewCommand
{
    public static void view(String path)
    {
        if(Desktop.isDesktopSupported())
        {
            try
            {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File(path));
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
        }
    }
}
