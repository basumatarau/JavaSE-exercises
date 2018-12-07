package com.codeHeap.io.streams;

import java.io.*;

public class BasicFileOutput {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + BasicFileOutput.class.getName()
                .replace(".", File.separator)
                .replace(
                        BasicFileOutput.class.getSimpleName(), "out1.txt"
                );

        try (LineNumberReader in =
                     new LineNumberReader(
                             new StringReader("test input string...\n"
                                     + "this is the next line\n"
                                     + "this is another line\n"
                                     + "this is the last line..."
                             )
                     );

             PrintWriter out =
                     new PrintWriter(
                             new BufferedWriter(
                                     new FileWriter(path)
                             )
                     )
        ) {
            String s;
            while ((s = in.readLine()) != null) {
                out.println(in.getLineNumber() + ": " + s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
