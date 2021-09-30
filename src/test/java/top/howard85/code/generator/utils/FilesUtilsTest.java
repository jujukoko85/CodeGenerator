package top.howard85.code.generator.utils;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FilesUtilsTest {

    @Test
    public void test1() {
        File file = FilesUtils.getFileFromClassPath("templates");
        assertNotNull(file);
    }

}