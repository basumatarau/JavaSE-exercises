package com.codeHeap.threads.priorityQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        PriorityBlockingQueue<PrioritizedTask> q = new PriorityBlockingQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new PrioritizedTaskProducer(q, executorService));
        //slightly holds the main thread so the console output gets neat
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("interrupted from main");
        }
        executorService.execute(new PrioritizedTaskConsumer(q));

    }
}
