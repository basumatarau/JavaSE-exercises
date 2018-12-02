package com.CodeHeap.IO.ChannelsAndBuffers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferedToText {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
                + BufferedToText.class.getName().replaceAll("\\.", File.separator)
                .replace(BufferedToText.class.getSimpleName(), "byteBufferToText.txt");

        FileChannel channel = new FileOutputStream(path).getChannel();
        channel.write(ByteBuffer.wrap("Some text...".getBytes()));
        channel.close();

        channel = new FileInputStream(path).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        channel.read(buff);

        buff.flip();
        System.out.println(buff);
        System.out.println(buff.asCharBuffer());

        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println(buff);
        System.out.println("Decoded using "+ encoding + ": " + Charset.forName(encoding).decode(buff));

        channel = new FileOutputStream(path).getChannel();
        channel.write(ByteBuffer.wrap("Some text...".getBytes("UTF_16BE")));
        channel.close();

        channel = new FileInputStream(path).getChannel();
        buff.clear();
        channel.read(buff);
        buff.flip();
        System.out.println(buff);
        System.out.println(buff.asCharBuffer());

        channel = new FileOutputStream(path).getChannel();
        buff = ByteBuffer.allocate(30);
        buff.asCharBuffer().put("Some text...");
        channel.write(buff);
        channel.close();

        buff.rewind();
        channel = new FileInputStream(path).getChannel();

        System.out.println(buff);
        System.out.println(buff.asCharBuffer());
        buff.clear();
        System.out.println(buff);
        System.out.println(buff.asCharBuffer());
        channel.read(buff);

        System.out.println(buff);
        System.out.println(buff.asCharBuffer());
        buff.flip();
        System.out.println(buff);
        System.out.println(buff.asCharBuffer());

    }
}
