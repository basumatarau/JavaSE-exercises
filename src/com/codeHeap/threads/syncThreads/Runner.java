package com.codeHeap.threads.syncThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Waiting waiting = new Waiting();
        Alarmer alarmer = new Alarmer(waiting);
        executorService.execute(waiting);
        executorService.execute(alarmer);

        try {
            if(!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("shutting down the executorService");
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
