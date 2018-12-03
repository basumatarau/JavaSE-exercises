package com.CodeHeap.IO.ChannelsAndBuffers.LockingMappedFiles;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {
    static final int length = 0x8FFFF;
    static FileChannel fc;
    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + LockAndModify.class.getName().replace(LockAndModify.class.getSimpleName(), "")
            .replaceAll("\\.", File.separator);

    public static void main(String[] args) throws IOException{
        fc = new RandomAccessFile(path+"sahredFile.txt", "rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte)'x');
        }
        new LockAndModify(out, 0, length/3);
        new LockAndModify(out, length/2, length/2 + length/4);

    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buffer;
        private int start;
        private int end;

        LockAndModify(ByteBuffer buffer, int start, int end) {
            this.start = start;
            this.end = end;
            buffer.limit(end);
            buffer.position(start);
            this.buffer = buffer.slice();
            start();
        }

        @Override
        public void run() {
            try {

                //critical section goes here...
                FileLock lock = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (buffer.position() < buffer.limit() - 1) {
                    buffer.put((byte) (buffer.get() + 1));
                }
                lock.release();

                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
