package com.codeHeap.threads.countdownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {

    private CountDownLatch latch;
    private int id = ++counter;
    private static int counter = 0;
    private Random rand = new Random();

    TaskPortion(CountDownLatch latch){
        this.latch = latch;
    }

    public void doWrok() throws InterruptedException{
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " completed");
    }

    @Override
    public void run() {
        try {
            doWrok();
            latch.countDown();
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}
