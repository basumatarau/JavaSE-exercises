package com.codeHeap.threads.horseracing;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;
    private int strides = 0;
    private static Random random = new Random(47);
    private static CyclicBarrier barrier;

    Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    synchronized int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                makeStride();
                barrier.await();
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        } catch (BrokenBarrierException e) {
            System.out.println("broken barrier");
        }
    }

    synchronized private void makeStride() {
        strides+=random.nextInt(3);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id;
    }

    public String tracks(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            result.append("*");
        }
        return result.append(id).toString();
    }
}
