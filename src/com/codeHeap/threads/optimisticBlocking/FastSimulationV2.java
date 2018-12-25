package com.codeHeap.threads.optimisticBlocking;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FastSimulationV2 {
    static final int N_ELEMENTS = 100000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS = 50;
    static final int[][] GRID = new int[N_ELEMENTS][N_GENES];

    private static long mutationCounter = 0;

    static Random random = new Random(47);

    static class Evolver implements Runnable{
        @Override
        public void run() {
            while(!Thread.interrupted()){
                int element = random.nextInt(N_ELEMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int previous = element - 1;
                    if(previous<0)
                        previous = N_ELEMENTS - 1;
                    int next = element + 1;
                    if(next>=N_ELEMENTS){
                        next = 0;
                    }

                    synchronized (GRID) {
                        mutationCounter++;
                        GRID[element][i] += GRID[previous][i] + GRID[next][i];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENTS; i++) {
            for (int j = 0; j < N_GENES; j++) {
                GRID[i][j] = random.nextInt();
            }
        }

        for (int i = 0; i < N_EVOLVERS; i++) {
            executorService.execute(new Evolver());
        }
        TimeUnit.MILLISECONDS.sleep(5000);
        executorService.shutdownNow();
        System.out.println("Mutations: " + mutationCounter);
    }
}
