package com.codeHeap.threads.fibonacci;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.codeHeap.threads.fibonacci.ThreadMethod.*;

public class Runner {
    public static void main(String[] args) {
        Future<? extends Integer> future = runTask(new FibonacciSumTask(10));

        boolean stop = false;
        while(!stop) {
            if(future.isDone()) {
                stop = true;
                try {
                    System.out.println("fibonacci sum: " + future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
