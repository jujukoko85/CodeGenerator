package top.howard85.code.generator.utils;

import java.io.File;

public class FilesUtils {

    public static File getFileFromClassPath(String name) {
        if (null == name || 0 == name.length()) {
            return null;
        }
        name = name.startsWith("/") ? name.substring(1) : name;
        String path = Thread.currentThread().getContextClassLoader().getResource(name).getPath();
        return new File(path);
    }
}
