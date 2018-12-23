package com.codeHeap.threads.restaurantV4;

import java.util.concurrent.TimeUnit;

public class Table implements Runnable{
    private static int counter = 0;
    private int id = ++counter;
    private Restaurant restaurant;
    private volatile int nClients = 0;
    private Waiter waiter;
    private OrderTicket ticket;
    volatile boolean readyToBeServed = false;

    OrderTicket getTicket(){
        return ticket;
    }

    Table(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    int getnClients() {
        return nClients;
    }

    synchronized void addClient(){
        if(nClients==0){
            ticket = new OrderTicket(this);
            try {
                waiter = restaurant.waiters.take();
            }catch (InterruptedException e){
                System.out.println(this + " has been interrupted");
            }
        }
        nClients++;
    }
    synchronized void removeClient(){
        nClients--;
        if(nClients==0){
            try {
                System.out.println("#releasing " + this + " and " + waiter);

                restaurant.tables.put(this);
                restaurant.waiters.put(waiter);
            }catch (InterruptedException e){
                System.out.println(this + " has been interrupted");
            }
        }
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100);

                if(ticket!=null && ticket.filled){
                    waiter.collectOrders(ticket);
                    ticket = new OrderTicket(this);
                }
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + " ";
    }
}
