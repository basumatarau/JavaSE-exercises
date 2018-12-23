package com.codeHeap.threads.restaurantV3;

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
                Order order = restaurant.orders.take();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(50));
                Plate plate = new Plate(order, order.orderedFood());
                order.getWaiter().filledOrders.put(plate);
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
