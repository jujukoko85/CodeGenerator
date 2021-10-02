package top.howard85.code.generator.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesUtils {

    public static File getFileFromClassPath(String name) {
        if (null == name || 0 == name.length()) {
            return null;
        }
        name = name.startsWith("/") ? name.substring(1) : name;
        String path = Thread.currentThread().getContextClassLoader().getResource(name).getPath();
        return new File(path);
    }

    public static File appendJava(String fileDir, String fileName, String content) throws IOException {
        Path dir = Paths.get(fileDir);
        Files.createDirectories(dir);
        Path file = Paths.get(fileDir, fileName);
        Files.createFile(file);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.toFile(), true));
        bw.write(content);
        bw.flush();
        return file.toFile();
    }
}
