package com.codeHeap.threads.ornamentalGarden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean cancelled = false;

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
            synchronized (this) {
                number++;
            }
            System.out.println(this + " Total: " + count.increment());

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " interrupted");
                cancel();
            }
        }
        System.out.println("stopping " + this);
    }

    synchronized public int getValue(){
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrances(){
        int result = 0;
        for (Entrance entrance : entrances) {
            result+=entrance.getValue();
        }
        return result;
    }
}
