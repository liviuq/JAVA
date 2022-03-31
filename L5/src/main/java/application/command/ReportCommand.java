package application.command;

import application.Catalog;
import freemarker.template.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ReportCommand
{
    public static void report(Catalog catalog) throws IOException, TemplateException
    {
        //initial FreeMaker configurations
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        //creating the data model
        Map<String, Object> model = new HashMap<>();

        model.put("title", catalog.getName());
        model.put("items", catalog.getItems());

        Template template;
        try {
            template = cfg.getTemplate("report.ftlh");
            try ( Writer fileWriter = new FileWriter(new File("web/output.html"))) {
                template.process(model, fileWriter);
            } catch (IOException | TemplateException ex) {
                Logger.getLogger(ReportCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
