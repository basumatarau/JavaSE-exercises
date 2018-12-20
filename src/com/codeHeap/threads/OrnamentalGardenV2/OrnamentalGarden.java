package com.codeHeap.threads.OrnamentalGardenV2;

import java.util.concurrent.*;

public class OrnamentalGarden {
    private static final int SIZE = 1000;
    private static CountDownLatch latch = new CountDownLatch(SIZE-1);

    public static CountDownLatch getLatch() {
        return latch;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i < SIZE; i++) {
            executorService.execute(new Entrance(i));
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e){
            System.out.println("interrupted from " + Thread.currentThread());
        }

        executorService.shutdownNow();

        System.out.println("#Total centrally counted: " + Entrance.getTotalCount());
        System.out.println("#Total counted at different entrances: " + Entrance.sumEntrances());
    }
}
