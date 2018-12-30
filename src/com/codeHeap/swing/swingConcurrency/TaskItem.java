package com.codeHeap.swing.swingConcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class TaskItem<T, C extends Callable<T>> {
    public final Future<T> future;
    public final C task;

    TaskItem(Future<T> future, C task){
        this.future = future;
        this.task = task;
    }
}
