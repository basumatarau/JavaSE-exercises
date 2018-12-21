package com.codeHeap.threads.priorityQueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTaskProducer implements Runnable{

    private Random random = new Random(47);
    private Queue<? super PrioritizedTask> queue;
    private ExecutorService exec;

    PrioritizedTaskProducer(Queue<? super PrioritizedTask> queue, ExecutorService exec){
        this.exec = exec;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        try{
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(100);
                queue.add(new PrioritizedTask(10));
            }

            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            queue.add(new PrioritizedTask.EndSantinel(-1, exec));
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("Finished prioritizedTaskProducer");
    }
}
