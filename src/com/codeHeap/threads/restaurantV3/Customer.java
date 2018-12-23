package com.codeHeap.threads.restaurantV3;

import com.codeHeap.threads.restaurantV3.food.Course;
import com.codeHeap.threads.restaurantV3.food.Food;

import java.util.concurrent.SynchronousQueue;

public class Customer implements Runnable{
    private static int counter = 0;
    private int id = ++counter;

    private final Waiter waiter;

    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    Customer(Waiter waiter){
        this.waiter = waiter;
    }

    public void deliver(Plate plate) throws InterruptedException{
        placeSetting.put(plate);
    }

    @Override
    public void run() {
        for (Course courseItem : Course.values()) {
            Food food = courseItem.randomSelection();

            try {
                waiter.placeOrder(this, food);
                Plate plate = placeSetting.take();
                System.out.println(this + " is eating " + plate.getFood());
            }catch (InterruptedException e){
                System.out.println(this + " has been interrupted");
                break;
            }

        }
        System.out.println(this + "has finished meal and leaving the restaurant");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + " ";
    }
}
