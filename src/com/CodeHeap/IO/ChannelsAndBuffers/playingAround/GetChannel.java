package com.CodeHeap.IO.ChannelsAndBuffers.playingAround;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    public static void main(String[] args) throws Exception{

        String path = System.getProperty("user.dir")+ File.separator + "src" +File.separator
                + GetChannel.class.getName().replaceAll("\\.", File.separator)
                .replace(GetChannel.class.getSimpleName(), "in.txt");

        FileChannel channel = new FileOutputStream(path).getChannel();

        channel.write(ByteBuffer.wrap("Some text...".getBytes()));
        channel.close();
        channel = new RandomAccessFile(path ,"rw").getChannel();
        channel.position(channel.size());
        channel.write(ByteBuffer.wrap("\nSome more text...".getBytes()));
        channel.close();

        channel = new FileInputStream(path).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        channel.read(buff);
        buff.flip();
        while(buff.hasRemaining()){
            System.out.print((char)buff.get());
        }

    }
}
