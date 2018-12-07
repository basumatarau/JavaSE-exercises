package com.codeHeap.io.filesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessFiles {
    public interface Strategy {
        void process(File file) throws IOException;
    }

    private Strategy instance;
    private String fileExtension;

    ProcessFiles(Strategy strategy, String fileExtension) {
        this.fileExtension = fileExtension;
        this.instance = strategy;
    }

    public long start(String... args) throws IOException {
        long totalSize = 0;
        try {
            if (args.length == 0) {
                totalSize += processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        totalSize += processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + fileExtension)) {
                            arg += "." + fileExtension;
                        }
                        File file = new File(arg);
                        instance.process(file.getCanonicalFile());
                        totalSize += file.length();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalSize;
    }

    public long processDirectoryTree(File root) throws IOException {
        long totalSize = 0;
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + fileExtension)) {
            instance.process(file.getCanonicalFile());
            totalSize += file.length();
        }
        return totalSize;
    }

    private static class ProcessorLogic implements Strategy {
        @Override
        public void process(File file) throws IOException {
            if (lastModifiedTime < file.lastModified()) {
                System.out.println(file.getCanonicalPath());
            }
        }

        long lastModifiedTime;

        public ProcessorLogic(long lastModifiedTime) {
            this.lastModifiedTime = lastModifiedTime;
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long theDayBefore = new Date().getTime() - (long) (1000 * 3600 * 24);
        System.out.println(sdf.format(theDayBefore));
        ProcessFiles processor = new ProcessFiles(new ProcessorLogic(theDayBefore), "java");
        System.out.println("Total size: " + processor.start(args) + " kB");
    }
}
