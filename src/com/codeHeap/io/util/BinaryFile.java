package com.codeHeap.io.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        BufferedInputStream in =
                new BufferedInputStream(
                        new FileInputStream(file)
                );
        try {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        } finally {
            in.close();
        }
    }

    public static byte[] read(String path) throws IOException {
        return read(new File(path).getAbsoluteFile());
    }

    public static class Test {
        public static void main(String[] args) {
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
                    + BinaryFile.class.getName().replaceAll("\\.", File.separator) + ".java";

            Map<Byte, Integer> byteMap = new TreeMap<>();
            try {
                for (byte b : read(path)) {
                    boolean found = false;
                    for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()) {
                        if (entry.getKey().equals(b)) {
                            entry.setValue(entry.getValue() + 1);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        byteMap.put(b, 1);
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()) {
                System.out.println(Integer.toHexString(entry.getKey()) + "=" + entry.getValue());
            }
        }
    }
}
