package com.codeHeap.threads.restaurantV4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
    private static int counter = 0;
    private final int id = ++counter;
    private Restaurant restaurant;
    private Random random = new Random(47);

    Chef(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                OrderTicket orderTicket = restaurant.orderTickets.take();

                for (Order order : orderTicket.getOrders()) {
                    System.out.println("cooking order: " + order);
                    Plate plate = new Plate(order, order.orderedFood());

                    TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
                    System.out.println(order + " is ready to be served!");

                    orderTicket.getTable().getWaiter().filledOrders.put(plate);
                }
            }
        }catch (InterruptedException e){
            System.out.println(this + "has been interrupted");
        }
        System.out.println(this + " is off duty");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + " ";
    }
}
