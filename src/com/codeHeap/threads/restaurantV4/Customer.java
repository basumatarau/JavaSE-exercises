package com.codeHeap.threads.restaurantV4;

import com.codeHeap.threads.restaurantV4.food.Course;
import com.codeHeap.threads.restaurantV4.food.Food;

import java.util.concurrent.SynchronousQueue;

public class Customer implements Runnable{
    private static int counter = 0;
    private int id = ++counter;

    private final Table table;

    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    Customer(Table table){
        this.table = table;
        table.addClient();
    }

    void deliver(Plate plate) throws InterruptedException{
        placeSetting.put(plate);
    }

    @Override
    public void run() {
        for (Course courseItem : Course.values()) {
            Food food = courseItem.randomSelection();
            try {

                table.getTicket().addOrder(new Order(this, food));

                System.out.println(this + "expecting: " + food + ", served by: " + table.getWaiter());

                Plate plate = placeSetting.take();
                System.out.println(this + " is eating " + plate.getFood());

            }catch (InterruptedException e){
                System.out.println(this + " has been interrupted");
                break;
            }
        }
        table.removeClient();
        System.out.println(this + " has finished its meal and leaving the restaurant");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id + " ";
    }
}
