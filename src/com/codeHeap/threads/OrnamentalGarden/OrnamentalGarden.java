package com.codeHeap.threads.OrnamentalGarden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> futures = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Future<?> submit = executorService.submit(new Entrance(i));
            futures.add(submit);
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e){
            System.out.println("interrupted from " + Thread.currentThread());
        }

        //Entrance.cancel();
        for (Future future : futures) {
            future.cancel(true);
        }
        executorService.shutdown();

        System.out.println("Total centrally counted: " + Entrance.getTotalCount());
        System.out.println("Total counted at different entrances: " + Entrance.sumEntrances());
    }
}
