package com.codeHeap.swing.swingConcurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager<T, C extends Callable<T>>
        extends ArrayList<TaskItem<T, C>> {

    private ExecutorService exec = Executors.newCachedThreadPool();

    public void addTask(C task) {
        add(new TaskItem<>(exec.submit(task), task));
    }

    public List<T> getResults() {
        List<T> result = new ArrayList<>();
        Iterator<TaskItem<T, C>> iterator = iterator();
        while (iterator.hasNext()) {
            TaskItem<T, C> next = iterator.next();
            if (next.future.isDone()) {
                try {
                    result.add(next.future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
                iterator.remove();
            }
        }
        return result;
    }

    public List<String> purge() {
        List<String> result = new ArrayList<>();
        Iterator<TaskItem<T, C>> iterator = iterator();
        while (iterator.hasNext()) {
            TaskItem<T, C> next = iterator.next();
            if (!next.future.isDone()) {
                result.add("cancelling " + next.task);
                next.future.cancel(true);
                iterator.remove();
            }
        }
        return result;
    }

}
