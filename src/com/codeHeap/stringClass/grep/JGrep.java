package com.codeHeap.stringClass.grep;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    private static BufferedReader bfr;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: \'file path\' \'regular expression\'");
            System.exit(0);
        }

        Pattern pattern = Pattern.compile(args[args.length - 1]);
        Matcher matcher = pattern.matcher("");

        String[] list = new File(args[0]).list();
        if(list == null){
            System.out.println("no files found in the directory: "+ args[0]);
            System.exit(0);
        }
        for (String fileName : list) {
            openBFR(fileName);
            String line;
            int lineNum = 0;
            while ((line = getLine()) != null) {
                matcher.reset(line);
                ++lineNum;
                while (matcher.find()) {
                    System.out.println("line " + lineNum + ": " + matcher.group() + ", pos:" + matcher.start());
                }
            }
            dispose();
        }
    }

    private static void openBFR(String fname) {

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
                + JGrep.class.getName().replaceAll("[.]", File.separator).replaceAll(
                JGrep.class.getSimpleName(), "") + File.separator;

        FileReader reader = null;
        try {
            reader = new FileReader(new File(path + fname));
            bfr = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + fname);
        } catch (Exception e) {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                System.out.println("couldn't close file: " + fname);
            }
            throw e;
        }
    }

    private static String getLine() {
        try {
            if (bfr.ready()) {
                return bfr.readLine();
            }
        } catch (IOException e) {
            System.out.println("File reading error");
        }
        return null;
    }

    private static void dispose() {
        try {
            bfr.close();
        } catch (IOException e) {
            System.out.println("file couldn't have been disposed");
        }
    }

}
