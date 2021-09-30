package top.howard85.code.generator.generation;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

public interface Generator {

    String merge(Map<String, Object> data, String template) throws IOException, TemplateException;
}
