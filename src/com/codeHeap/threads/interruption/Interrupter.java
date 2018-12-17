package com.codeHeap.threads.interruption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Interrupter {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Sleeper(3));
        Future<?> submit = executorService.submit(new Sleeper(2));

        System.out.println("sending interrupted to the threads");
        submit.cancel(true);
        executorService.shutdown();



    }
}
