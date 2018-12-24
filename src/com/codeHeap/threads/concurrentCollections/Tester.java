package com.codeHeap.threads.concurrentCollections;

import com.codeHeap.arrays.countingGenerator.Generated;
import com.codeHeap.arrays.countingGenerator.RandomGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Tester<C> {
    static int testReps = 10;
    static int testCycles = 1000;
    static int containerSize = 1000;

    abstract C containerInitializer();
    abstract void startReadersAndWriters();
    C container;
    private String testId;
    int nReaders;
    int nWriters;

    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    CountDownLatch endLatch;
    static ExecutorService executorService = Executors.newCachedThreadPool();
    Integer[] writeData;

    Tester(String testId, int nReaders, int nWriters){
        this.testId = testId + " " + nReaders + "r " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;

        writeData = Generated.fill(Integer.class, new RandomGenerator.Integer(), containerSize);
        for (int i = 0; i < testReps; i++) {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }

    private void runTest() {
        endLatch = new CountDownLatch(nReaders + nWriters);
        container = containerInitializer();
        startReadersAndWriters();
        try{
            endLatch.await();
        } catch (InterruptedException e) {
            System.out.println(this + " has been interrupted");
        }
        System.out.println(String.format("%-27s %14d %14d",
                testId, readTime, writeTime));

        if(readTime!=0 && writeTime!=0){
            System.out.println(String.format("%-27s %14d",
                    "readTime + writeTime =", readTime + writeTime));
        }
    }

    abstract class TestTask implements Runnable{
        abstract void test();
        abstract void putResults();
        long duration;

        @Override
        public void run() {
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;

            synchronized (Tester.this){
                putResults();
            }
            endLatch.countDown();
        }
    }

    public static void initMain(String[] args) {
        System.out.println(String.format("%-27s %14s %14s", "Type", "Read time", "Write time"));
    }

}
