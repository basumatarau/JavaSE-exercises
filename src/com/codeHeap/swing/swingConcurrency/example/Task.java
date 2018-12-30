package com.codeHeap.swing.swingConcurrency.example;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private static int counter = 0;
    private int id = ++counter;

    @Override
    public void run() {
        System.out.println(this + " started");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println(this + " has been interrupted");
            return;
        }
        System.out.println(this + " completed");
    }

    @Override
    public String toString() {
        return "Task#" + id;
    }

    public int getId() {
        return id;
    }
}
