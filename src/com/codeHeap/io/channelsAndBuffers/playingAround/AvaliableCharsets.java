package com.codeHeap.io.channelsAndBuffers.playingAround;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

public class AvaliableCharsets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();

        for (Map.Entry<String, Charset> charsetEntry : charsets.entrySet()) {
            System.out.print("CharsetName: " + charsetEntry.getKey());
            String delimiter = "";
            boolean intro = true;
            for (String alias : charsetEntry.getValue().aliases()) {
                if (intro) {
                    System.out.print(", aliases: ");
                    intro = false;
                }
                System.out.print(delimiter + alias);
                delimiter = ", ";
            }
            System.out.println();
        }
    }
}
