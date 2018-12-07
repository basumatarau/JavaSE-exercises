package com.codeHeap.io.channelsAndBuffers.zipGzip;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompress {
    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + GZIPCompress.class.getName().replace(GZIPCompress.class.getSimpleName(), "")
            .replaceAll("\\.", File.separator);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader(path + "in.txt")
        );

        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream(path + "out.gz")
                )
        );
        System.out.println("writing file...");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        System.out.println("Reading file");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream(path + "out.gz")
                        )
                )
        );
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
