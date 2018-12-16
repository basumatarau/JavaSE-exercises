package com.codeHeap.threads.fibonacci;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FibRunnable implements Runnable {

    private int num;
    private Fibonacci fib = new Fibonacci();

    FibRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(fib.fibonacci4(i));
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            //futures.add(executorService.submit(new FibRunnable(i + 5)));
            Callable<Object> callable = Executors.callable(new FibRunnable(i + 5));
            futures.add(executorService.submit(callable));
        }
        for (Future future : futures) {
            try {
                if (future.isDone()) {
                    System.out.println("retrieved " + future.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        List<Future<Integer>> futures1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures1.add(executorService.submit(new FibonacciSumTask(i + 5)));
        }
        try {
            for (Future<Integer> integerFuture : futures1) {
                if (integerFuture.isDone()) {
                    System.out.println("fibonacci sum get: " + integerFuture.get());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
