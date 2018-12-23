package com.codeHeap.threads.restaurantV4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Waiter implements Runnable{
    private static int counter = 0;
    private final int id = ++counter;
    private Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

    Waiter(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    void collectOrders(OrderTicket ticket) throws InterruptedException{
        restaurant.orderTickets.put(ticket);
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){

                Plate plate = filledOrders.take();
                System.out.println(this + " received " + plate +
                        " delivering to " + plate.getOrder().getCustomer());

                System.out.println("ABOUT TO DELIVER!");
                plate.getOrder().getCustomer().deliver(plate);
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " is off duty ");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + " ";
    }
}
