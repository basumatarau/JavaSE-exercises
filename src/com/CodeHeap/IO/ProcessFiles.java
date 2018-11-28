package com.CodeHeap.IO;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy instance;
    private String fileExtension;

    ProcessFiles(Strategy strategy, String fileExtension) {
        this.fileExtension = fileExtension;
        this.instance = strategy;
    }

    public void start(String... args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + fileExtension)) {
                            arg += "." + fileExtension;
                        }
                        instance.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + fileExtension)) {
            instance.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        ProcessFiles processor = new ProcessFiles((file) -> System.out.println(file), "java");
        processor.start(args);
    }
}
