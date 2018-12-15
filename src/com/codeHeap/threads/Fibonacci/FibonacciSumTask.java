package com.codeHeap.threads.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FibonacciSumTask implements Callable<Integer> {

    private int num;
    private Fibonacci fib = new Fibonacci();

    FibonacciSumTask(int num){
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < num; i++) {
            result += fib.fibonacci4(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new FibonacciSumTask(i)));
        }
        try {
            for (Future<Integer> result : results) {
                if (result.isDone()) {
                    System.out.println(result.get());
                }
            }
        }catch(InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }finally{
            executorService.shutdown();
        }
    }
}
