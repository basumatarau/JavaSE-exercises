package com.codeHeap.threads.delayQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        DelayQueue<DelayedTask> q = new DelayQueue<>();

        for (int i = 0; i < 20; i++) {
            q.put(new DelayedTask(random.nextInt(5000)));
        }
        q.add(new DelayedTask.Sentinel(5000, executorService));

        executorService.execute(new DelayedTaskConsumer(q));
    }
}
