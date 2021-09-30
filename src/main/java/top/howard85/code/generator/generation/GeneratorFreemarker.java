package top.howard85.code.generator.generation;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import top.howard85.code.generator.utils.FilesUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class GeneratorFreemarker implements Generator {

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

    public GeneratorFreemarker() throws IOException {
        cfg.setDirectoryForTemplateLoading(FilesUtils.getFileFromClassPath("templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    public String merge(Map<String, Object> data, String template) throws TemplateException, IOException {
        Template t = cfg.getTemplate(template);
        StringWriter writer = new StringWriter();
        t.process(data, writer);
        return writer.toString();
    }

}
