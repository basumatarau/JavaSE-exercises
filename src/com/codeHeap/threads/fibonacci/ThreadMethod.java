package com.codeHeap.threads.fibonacci;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMethod {
    public static <T> Future<? extends T> runTask(Callable<? extends T> callable){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return executorService.submit(callable);
    }
}
