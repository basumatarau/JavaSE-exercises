package com.codeHeap.threads.priorityQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PrioritizedTaskConsumer implements Runnable{
    private PriorityBlockingQueue<? extends PrioritizedTask> queue;

    PrioritizedTaskConsumer(PriorityBlockingQueue<? extends PrioritizedTask> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                queue.take().run();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("finished priorityTaskConsumer");
    }
}
