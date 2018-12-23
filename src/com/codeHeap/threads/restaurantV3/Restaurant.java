package com.codeHeap.threads.restaurantV3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Restaurant implements Runnable{

    private List<Waiter> waiters = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService executorService;
    private Random random = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingQueue<>();

    Restaurant(ExecutorService executorService, int nWaiters, int nChefs){
        this.executorService = executorService;
        for (int i = 0; i < nWaiters; i++) {
            Waiter waiter = new Waiter(this);
            executorService.execute(waiter);
            waiters.add(waiter);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            executorService.execute(chef);
            chefs.add(chef);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Waiter waiter = waiters.get(random.nextInt(waiters.size()));
                Customer customer = new Customer(waiter);
                executorService.execute(customer);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " is closing");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
