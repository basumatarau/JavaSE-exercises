package com.codeHeap.threads.restaurantV4;

import java.util.*;
import java.util.concurrent.*;

public class Restaurant implements Runnable{

    private ExecutorService executorService;

    BlockingQueue<Waiter> waiters;
    BlockingQueue<Table> tables;
    BlockingQueue<OrderTicket> orderTickets = new LinkedBlockingQueue<>();

    private Random random = new Random(47);

    Restaurant(ExecutorService executorService, int nWaiters, int nChefs, int nTables){
        this.executorService = executorService;
        tables = new ArrayBlockingQueue<>(nTables);
        waiters = new ArrayBlockingQueue<>(nWaiters);

        for (int i = 0; i < nTables; i++) {
            Table table = new Table(this);
            tables.add(table);
            executorService.execute(table);
        }
        for (int i = 0; i < nWaiters; i++) {
            Waiter waiter = new Waiter(this);
            executorService.execute(waiter);
            waiters.add(waiter);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            executorService.execute(chef);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                Table table = tables.take();
                System.out.println("more customers!");

                for (int i = 0; i < random.nextInt(4) + 1; i++) {
                    Customer customer = new Customer(table);
                    if(!Thread.interrupted()){
                        executorService.execute(customer);
                        System.out.println(table + " has been taken by " + customer);
                    }
                }
                table.readyToBeServed = true;

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
