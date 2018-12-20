package com.codeHeap.threads.OrnamentalGardenV2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean cancelled = false;
    private static CountDownLatch latch = OrnamentalGarden.getLatch();

    Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public static void cancel() {
        cancelled = true;
    }

    @Override
    public void run() {
        while (!cancelled) {
            //no need to sync the subtask (increment) since getValue()
            // method is called only after all the threads get 'over the latch'

            number++;

            System.out.println(this + " Total: " + count.increment());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " interrupted");
                cancel();
            }
        }
        latch.countDown();
        System.out.println("stopping " + this + ", latch count: " + latch.getCount());
    }

    synchronized public int getValue(){
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount(){
        try {
            latch.await();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        return count.value();
    }

    public static int sumEntrances(){
        int result = 0;
        try {
            latch.await();
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        for (Entrance entrance : entrances) {
            result+=entrance.getValue();
        }
        return result;
    }
}
