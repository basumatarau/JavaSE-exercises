package com.codeHeap.threads.delayQueue;

import java.util.concurrent.DelayQueue;

public class DelayedTaskConsumer implements Runnable{
    private DelayQueue<? extends DelayedTask> queue;

    DelayedTaskConsumer(DelayQueue<? extends DelayedTask> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!Thread.interrupted()) {
                queue.take().run();
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }

        System.out.println("finished delayConsumer");
    }
}
