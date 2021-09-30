package top.howard85.code.generator.generation;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws IOException, TemplateException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
//        cfg.setDirectoryForTemplateLoading(new File("/templates"));
        cfg.setClassForTemplateLoading(Test.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Template template = cfg.getTemplate("entity.ftl");
        Person data = new Person().setName("world");
        StringWriter sw = new StringWriter();
        template.process(data, sw);
        System.out.println(sw.toString());
    }
}
