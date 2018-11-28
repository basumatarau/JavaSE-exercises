package com.CodeHeap.IO;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DirList {

    public static void main(final String[] args) {
        File path = new File("./");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(".");

                @Override
                public boolean accept(File file, String s) {
                    File fname = new File(s);
                    if (fname.isDirectory())
                        return false;

                    boolean accepted = false;

                    try (BufferedReader br =
                                 new BufferedReader(
                                         new FileReader(fname)
                                 )
                    ) {
                        String line;
                        while (br.ready() && (line = br.readLine()) != null) {
                            if (pattern.matcher(line).find()) {
                                accepted = true;
                                break;
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return accepted;
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        Map<String, Long> fNameSize = new HashMap<>();
        Long totalSize = 0L;
        for (String s : list) {
            File f = new File(s);
            fNameSize.put(f.getName(), f.length());
            totalSize += f.length();
        }
        for (Map.Entry<String, Long> entry : fNameSize.entrySet()) {
            System.out.println("File name: " + entry.getKey() + ", size: " + entry.getValue() + " bytes");
        }
        System.out.println("total size: " + totalSize + " bytes");
    }
}
