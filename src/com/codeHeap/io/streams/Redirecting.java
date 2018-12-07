package com.codeHeap.io.streams;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintWriter outOne = new PrintWriter(System.out, true);
        outOne.println("Hello world!");


        String source = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + Redirecting.class.getName()
                .replace(".", File.separator) + ".java";
        String dest = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + Redirecting.class.getName()
                .replace(".", File.separator)
                .replace(Redirecting.class.getSimpleName(), "dest.txt");

        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(
                        new File(source)
                )
        );
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(
                                new File(dest)
                        )
                )
        );
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=buffReader.readLine())!=null){
            System.out.println(line);
        }
        out.close();
        System.setOut(console);

    }
}
