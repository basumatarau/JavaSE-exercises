package com.codeHeap.threads.restaurantV3;

import com.codeHeap.threads.restaurantV3.food.Food;

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

    public void placeOrder(Customer customer, Food food){
        restaurant.orders.add(new Order(customer, this, food));
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                Plate take = filledOrders.take();
                System.out.println(this + " received " + take +
                        " delivering to " + take.getOrder().getCustomer());
                take.getOrder().getCustomer().deliver(take);
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
