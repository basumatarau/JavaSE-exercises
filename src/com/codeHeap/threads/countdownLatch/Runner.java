package com.codeHeap.threads.countdownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    private static int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new TaskPortion(latch));
        }

        System.out.println("all tasks have been launched");
        executorService.shutdown();
    }
}
