package com.codeHeap.threads.syncThreads;

import java.util.concurrent.TimeUnit;

public class Alarmer implements Runnable{
    final private Waiting waiting;

    Alarmer(Waiting waiting){
        this.waiting = waiting;
    }

    @Override
    public void run() {
        System.out.println("Alarmer is taking a pause before waking a " + waiting);
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        synchronized (waiting){
            System.out.println("Alarmer is waking up " + waiting);
            waiting.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
