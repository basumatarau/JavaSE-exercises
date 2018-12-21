package com.codeHeap.threads.delayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Runnable, Delayed {
    private final int id = ++counter;
    private static int counter = 0;
    private final int delta;
    private final long trigger;

    private static List<DelayedTask> sequence = new ArrayList<>();

    DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() +
                TimeUnit.NANOSECONDS.convert(
                        delta, TimeUnit.MILLISECONDS
                );

        sequence.add(this);
    }

    @Override
    public int compareTo(Delayed delayed) {
        DelayedTask that = (DelayedTask) delayed;
        if (trigger > that.trigger)
            return 1;
        if (trigger < that.trigger)
            return -1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d],", delta) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }


    public static class Sentinel extends DelayedTask {
        private ExecutorService exec;
        public Sentinel(int delayInMilliseconds, ExecutorService exec) {
            super(delayInMilliseconds);
            this.exec = exec;
        }

        @Override
        public void run() {
            for (DelayedTask delayedTask : sequence) {
                System.out.print(delayedTask.summary());
            }
            System.out.println();
            System.out.println(this + " is calling ShutdownNow()");
            exec.shutdownNow();
        }
    }

}
