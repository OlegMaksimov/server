package ru.maksimov.templates;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    private static final String HTML_DIR = "templates";
    private static PageGenerator pageGenerator;
    private final Configuration cfg;

    private PageGenerator() {
        this.cfg = new Configuration();
    }

    public static PageGenerator getInstance(){
        if (pageGenerator == null){
            pageGenerator = new PageGenerator();
        }
        return pageGenerator;
    }

    public String getPage(String fileName, Map<String,Object> data) {
        Writer writer = new StringWriter();
        try {
            Template template = cfg.getTemplate(HTML_DIR + File.separator + fileName);
            template.process(data,writer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

}
