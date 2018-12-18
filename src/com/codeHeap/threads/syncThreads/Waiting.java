package com.codeHeap.threads.syncThreads;

public class Waiting implements Runnable {
    @Override
    public void run() {

        synchronized (this) {
            try {
                System.out.println(this + " is starting to wait");
                wait();
                System.out.println(this + " has been notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
