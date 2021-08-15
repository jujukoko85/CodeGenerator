package top.howard85.code.generator;

import top.howard85.code.generator.generation.Generator;

import java.io.File;

public class Target {

    private File targetDir; //
    private Generator generator;

    public Target(File targetDir, Generator generator) {
        this.targetDir = targetDir;
        this.generator = generator;
    }
}
