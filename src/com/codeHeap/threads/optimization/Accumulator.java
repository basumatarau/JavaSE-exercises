package com.codeHeap.threads.optimization;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Accumulator {
    static long cycles = 50000L;
    private static final int N = 4;
    public static ExecutorService executorService = Executors.newFixedThreadPool(N * 2);

    private CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    private long duration;
    protected volatile int value;
    protected volatile int index;
    protected final static int SIZE = 100000;

    static int[] preLoaded = new int[SIZE];
    static {
        Random random = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = random.nextInt();
        }
    }

    protected String id;

    Accumulator(String id) {
        this.id = id;
    }

    public abstract void accumulate();
    public abstract long read();

    private class Modifier implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                accumulate();
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                System.out.println(this + " has been interrupted");
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable{
        volatile long value;
        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {

                //this is done in order to prevent optimization by compiler, hence:
                //noinspection MoveFieldAssignmentToInitializer
                Reader.this.value = read();
            }
            try{
                barrier.await();
            }catch (InterruptedException e){
                System.out.println(this + " has been interrupted");
            } catch (BrokenBarrierException e){
                throw new RuntimeException(e);
            }
        }
    }

    void timedTest(){
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            executorService.execute(new Reader());
            executorService.execute(new Modifier());
        }
        try{
            barrier.await();
        }catch (InterruptedException e) {
            System.out.println(this + " has been interrupted");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        duration = System.nanoTime() - start;
        System.out.println(
                String.format("%-13s: %13d", id, duration)
        );
    }

    static void compare(Accumulator acc1, Accumulator acc2){
        System.out.println(
                String.format("%-22s: %.2f", acc1 + "/" + acc2,
                        ((double) acc1.duration)/ ((double) acc2.duration))
        );
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
