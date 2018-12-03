package com.CodeHeap.IO.ChannelsAndBuffers.zipGzip;

import java.io.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + GZIPCompress.class.getName().replace(GZIPCompress.class.getSimpleName(), "")
            .replaceAll("\\.", File.separator);

    public static void main(String[] args) throws IOException {

        FileOutputStream f = new FileOutputStream(path + "out.zip");
        CheckedOutputStream checkedOut = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOut);
        BufferedOutputStream out = new BufferedOutputStream(zipOutputStream);

        BufferedReader in = new BufferedReader(
                new FileReader(path + "in.txt")
        );
        zipOutputStream.putNextEntry(new ZipEntry( "in.txt"));
        int ch;
        while ((ch = in.read()) != -1) {
            out.write(ch);
        }
        in.close();
        out.flush();

        in = new BufferedReader(
                new FileReader(path + "in2.txt")
        );
        zipOutputStream.putNextEntry(new ZipEntry("in2.txt"));
        while ((ch = in.read()) != -1) {
            out.write(ch);
        }
        in.close();
        out.flush();

        out.close();


    }
}
