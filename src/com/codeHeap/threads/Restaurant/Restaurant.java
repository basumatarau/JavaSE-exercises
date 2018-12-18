package com.codeHeap.threads.Restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    final Chef chef;
    final Waiter waiter;
    final BusBoy busBoy;

    boolean needCleanUp;
    Meal mealAtCheckOutCounter;
    ExecutorService exec;

    public void close(){
        System.out.println("restaurant is going to close");
        exec.shutdownNow();
    }

    Restaurant(){
        chef = new Chef(this);
        waiter = new Waiter(this);
        busBoy = new BusBoy(this);

        exec = Executors.newFixedThreadPool(3);
        exec.execute(chef);
        exec.execute(waiter);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
