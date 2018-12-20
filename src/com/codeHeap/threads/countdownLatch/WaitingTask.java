package com.codeHeap.threads.countdownLatch;

import java.util.concurrent.CountDownLatch;

public class WaitingTask implements Runnable{

    private CountDownLatch latch;
    private static int counter = 0;
    private final int id = ++counter;

    WaitingTask(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("latch barrier passed for " + this);
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + String.format("%1$-3d ", id);
    }
}
