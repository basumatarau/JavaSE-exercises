package com.codeHeap.io.streams;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(
                        "test input string...".getBytes()
                )
            )
        ){

            while(in.available()>0){
                System.out.println((char)in.readByte());
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
