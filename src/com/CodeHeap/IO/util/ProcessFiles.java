package com.CodeHeap.IO.util;

import com.CodeHeap.IO.filesAndDirectories.Directory;

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


    public static void main(String[] args) throws IOException {

        ProcessFiles processor = new ProcessFiles((f)->{
            int counter = 10;
            System.out.print("first 10 bytes of "+f.getName()+": ");
            for (byte b : BinaryFile.read(f)) {
                System.out.print(String.format("%02x ", b));
                if(counter--<0) break;
            }
            System.out.println();
        }, "class");
        System.out.println("Total size: " + processor.start(args) + " kB");
    }
}
