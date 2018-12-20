package com.codeHeap.threads.horseracing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRacing {
    private static final int FINISH_LINE = 100;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    private HorseRacing(int nHorses, final int pauseMs){

        barrier = new CyclicBarrier(nHorses, () -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < FINISH_LINE; i++) {
                sb.append("=");
            }
            System.out.println(sb.toString());
            for (Horse horse : horses) {
                System.out.println(horse.tracks());
            }
            for (Horse horse : horses) {
                if(horse.getStrides()>=FINISH_LINE){
                    System.out.println(horse + " won!");
                    executorService.shutdownNow();
                    return;
                }
            }
            try{
                TimeUnit.MILLISECONDS.sleep(pauseMs);
            }catch (InterruptedException e){
                System.out.println("barrier action sleep interrupted");
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            executorService.execute(horse);
        }

    }

    public static void main(String[] args) {
        int nHorses = 10;
        int pauseMs = 200;

        new HorseRacing(nHorses, pauseMs);
    }
}
