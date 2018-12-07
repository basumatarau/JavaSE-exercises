package com.codeHeap.io.streams;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader("test input string...");
        int ch;
        while ((ch = in.read()) != -1) {
            System.out.print((char) ch);
        }

    }
}
