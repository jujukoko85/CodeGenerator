package top.howard85.code.generator.generation;

import top.howard85.code.generator.entity.EntityClazz;

import java.io.File;
import java.io.IOException;

public interface Generator {

    File merge(File targetDir, EntityClazz clazz, String template) throws IOException;
}
