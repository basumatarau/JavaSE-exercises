package com.codeHeap.threads.priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    private static int counter = 0;
    private final int id = ++counter;
    private final int priority;
    private static Random random = new Random(47);

    private static List<PrioritizedTask> sequence = new ArrayList<>();

    PrioritizedTask(int priority){
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask prioritizedTask) {
        return priority < prioritizedTask.priority ? 1 : (priority > prioritizedTask.priority ? -1 : 0);
    }

    @Override
    public void run() {
        try{
            TimeUnit.MILLISECONDS.sleep(200);
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.print(this);
    }

    @Override
    public String toString() {
        return String.format("\n%1$-3d", priority) + " Task: " + id;
    }

    public String summary(){
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSantinel extends PrioritizedTask{
        private ExecutorService exec;
        EndSantinel(int priority, ExecutorService exec){
            super(priority);
            this.exec = exec;
        }

        @Override
        public void run() {
            for (PrioritizedTask prioritizedTask : sequence) {
                System.out.println(prioritizedTask.summary());
            }
            System.out.println("\n" + this + " is calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
