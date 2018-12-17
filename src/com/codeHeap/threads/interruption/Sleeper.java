package com.codeHeap.threads.interruption;

import java.util.concurrent.TimeUnit;

public class Sleeper implements Runnable{
    int sec;
    Sleeper(int sec){
        this.sec = sec;
    }
    @Override
    public void run() {
        synchronized (Sleeper.class) {
            try {
                TimeUnit.SECONDS.sleep(sec);
            } catch (InterruptedException e) {
                System.out.println("interrupted from " + Thread.currentThread());
            }
            System.out.println("woke up after " + sec + " s. sleep");
        }
    }

}
