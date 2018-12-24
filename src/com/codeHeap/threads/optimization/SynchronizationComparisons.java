package com.codeHeap.threads.optimization;

import java.util.concurrent.TimeUnit;

public class SynchronizationComparisons {

    private static Atomic atomic = new Atomic();
    private static  BaseLine baseLine = new BaseLine();
    private static Synchronized syncronized = new Synchronized();
    private static LockTest lockTest = new LockTest();

    public static void test(){
        System.out.println("============================");
        System.out.println(String.format("%-12s : %13d", "Cycles", Accumulator.cycles));
        baseLine.timedTest();
        syncronized.timedTest();
        lockTest.timedTest();
        atomic.timedTest();
        Accumulator.compare(syncronized, baseLine);
        Accumulator.compare(lockTest, baseLine);
        Accumulator.compare(atomic, baseLine);
        Accumulator.compare(syncronized, lockTest);
        Accumulator.compare(syncronized, atomic);
        Accumulator.compare(lockTest, atomic);
    }

    public static void main(String[] args) throws InterruptedException{
        int iterations = 5;
        System.out.println("warmup");
        baseLine.timedTest();
        for (int i = 0; i < iterations; i++) {
            test();
            Accumulator.cycles *= 2;
        }
        TimeUnit.MILLISECONDS.sleep(3000);
        Accumulator.executorService.shutdownNow();
    }
}
