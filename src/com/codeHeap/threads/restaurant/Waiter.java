package com.codeHeap.threads.restaurant;

import java.util.concurrent.TimeUnit;

public class Waiter extends Employee implements Runnable {
    private Restaurant restaurant;
    private Meal beingServed;

    Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.mealAtCheckOutCounter==null){
                        wait();
                    }
                }

                synchronized (restaurant.chef) {
                    beingServed = restaurant.mealAtCheckOutCounter;
                    restaurant.mealAtCheckOutCounter = null;
                    System.out.println(beingServed + " being served by " + this);
                }

                TimeUnit.MILLISECONDS.sleep(50);

                synchronized (restaurant.busBoy){
                    restaurant.needCleanUp = true;
                    restaurant.busBoy.notify();
                    System.out.println(this + " is telling a busboy to clean up");
                }
                System.out.println(this + " is ready to serve another meal");
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " has stopped working");
    }

}
