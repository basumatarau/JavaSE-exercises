package com.CodeHeap.IO.ChannelsAndBuffers.channelMapping;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers{
    private static void symmetricScramble(CharBuffer buffer){
        while(buffer.hasRemaining()){
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2);
            buffer.put(c1);
        }
    }

    public static void main(String[] args) {
        char[] chars = "some test string".toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(chars.length*2);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(chars);
        charBuffer.flip();

        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
    }
}
