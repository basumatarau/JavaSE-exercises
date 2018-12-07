package com.codeHeap.io.channelsAndBuffers.channelMapping;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {

    private static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + MappedIO.class.getName().replace(MappedIO.class.getSimpleName(), "")
            .replaceAll("\\.", File.separator);
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private static abstract class Tester {
        private String name;

        Tester(String name) {
            this.name = name;
        }

        public void run() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                long duration = System.nanoTime() - start;
                System.out.printf("%.2f s.\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    static Tester[] tests = {
            new Tester("Stream write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(path + "streamWriteTest.tmp")
                            )
                    );
                    //old school resource management
                    try {
                        for (int i = 0; i < numOfInts; i++) {
                            dos.writeInt(i);
                        }
                    } finally {
                        dos.close();
                    }
                }
            },
            new Tester("Mapped write") {
                @Override
                public void test() throws IOException {
                    FileChannel channel = new RandomAccessFile(path + "mappedWriteTest.tmp", "rw").getChannel();
                    IntBuffer rw = channel.
                            map(FileChannel.MapMode.READ_WRITE, 0, numOfInts * 4).asIntBuffer();

                    for (int i = 0; i < numOfInts; i++) {
                        rw.put(i);
                    }
                    channel.close();
                }
            },
            new Tester("Stream read") {
                @Override
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(path + "mappedWriteTest.tmp")
                            )
                    );
                    for (int i = 0; i < numOfInts; i++) {
                        dis.readInt();
                    }
                    dis.close();
                }
            },
            new Tester("Mapped read") {
                @Override
                public void test() throws IOException {
                    FileChannel channel = new RandomAccessFile(path + "streamWriteTest.tmp", "rw").getChannel();
                    IntBuffer intBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size()).asIntBuffer();
                    while (intBuffer.hasRemaining()) {
                        intBuffer.get();
                    }
                    channel.close();
                }
            },
            new Tester("Stream read/write") {
                @Override
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(path + "mappedWriteTest.tmp", "rw");
                    raf.writeInt(0);
                    for (int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.getFilePointer() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Maped read/write") {
                @Override
                public void test() throws IOException {
                    FileChannel channel = new RandomAccessFile(path + "streamWriteTest.tmp", "rw").getChannel();
                    IntBuffer intBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size()).asIntBuffer();
                    intBuffer.put(0);
                    for (int i = 1; i < numOfUbuffInts; i++) {
                        intBuffer.put(intBuffer.get(i-1));
                    }
                    channel.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : tests) {
            test.run();
        }
    }
}
