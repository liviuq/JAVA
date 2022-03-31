package application.command;

import application.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        //creating the data model
        Map<String, Object> model = new HashMap<>();
        model.put("title", catalog.getName());
        model.put("items", catalog.getItems());

        //getting the template
        Template template;
        template = cfg.getTemplate("report.ftlh");


        try (Writer fileWriter = new FileWriter(new File("web/output.html")))
        {
            template.process(model, fileWriter);
        }
        catch (IOException | TemplateException ex)
        {
            Logger.getLogger(ReportCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
