package top.howard85.code.generator.generation;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import top.howard85.code.generator.entity.EntityClazz;

import java.io.File;
import java.io.IOException;

public class GeneratorFreemarker implements Generator {

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

    public GeneratorFreemarker() throws IOException {
        cfg.setDirectoryForTemplateLoading(new File("/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    public File merge(File targetDir, EntityClazz clazz, String template) throws IOException {
        Template t = cfg.getTemplate(template);
        return null;
    }
}
