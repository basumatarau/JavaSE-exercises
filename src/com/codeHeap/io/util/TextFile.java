package com.codeHeap.io.util;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String> {

    public static String read(String fileName) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(fileName).getAbsoluteFile())
            );

            try {
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line).append('\n');
                }
            } finally {
                in.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String fileName) {

        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(
                                    new File(fileName).getAbsoluteFile()
                            )
                    )
            );
            try {
                for (String line : this) {
                    out.println(line);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public static class Test {
        public static void main(String[] args) {
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
                    + TextFile.class.getName().replaceAll("\\.", File.separator) + ".java";

            String thisSource = read(path);
            String outFile = path.replace(TextFile.class.getSimpleName() + ".java", "testOut.txt");
            write(outFile, thisSource);
            TextFile textFile = new TextFile(outFile);
            String outFile2 = path.replace(TextFile.class.getSimpleName() + ".java", "testOut2.txt");
            textFile.write(outFile2);

            TextFile words = new TextFile(path, "\\W+");
            TreeSet<String> wordSet = new TreeSet<>(words);
            System.out.println(wordSet.headSet("a"));

            Map<Character, Integer> tokenMap = new TreeMap<>();


            for (String word : words) {
                for (char c : word.toCharArray()) {
                    boolean found = false;
                    for (Map.Entry<Character, Integer> entry : tokenMap.entrySet()) {
                        if (entry.getKey().equals(c)) {
                            entry.setValue(entry.getValue() + 1);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        tokenMap.put(c, 1);
                    }
                }
            }
            System.out.println(tokenMap);
        }
    }
}
