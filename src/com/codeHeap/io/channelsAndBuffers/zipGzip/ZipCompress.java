package com.codeHeap.io.channelsAndBuffers.zipGzip;

import java.io.*;
import java.util.zip.*;

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
        zipOutputStream.putNextEntry(new ZipEntry("in.txt"));
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
        System.out.println("Checksum: " + checkedOut.getChecksum().getValue());


        FileInputStream fin = new FileInputStream(path + "out.zip");
        CheckedInputStream checkedIn = new CheckedInputStream(fin, new Adler32());
        ZipInputStream zipIn = new ZipInputStream(checkedIn);
        BufferedInputStream buffIn = new BufferedInputStream(zipIn);

        ZipEntry nextEntry;
        while ((nextEntry = zipIn.getNextEntry()) != null) {
            System.out.println("Reading file: " + nextEntry);
            while ((ch = buffIn.read()) != -1) {
                System.out.write(ch);
            }
            System.out.println();
        }

        buffIn.close();
    }
}
