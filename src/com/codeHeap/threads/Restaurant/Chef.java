package com.codeHeap.threads.Restaurant;

import java.util.concurrent.TimeUnit;

public class Chef extends Employee implements Runnable {
    private Restaurant restaurant;
    private int mealCounter = 10;

    Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    while(restaurant.mealAtCheckOutCounter!=null){
                        System.out.println(this + " is waiting for the meal to be claimed");
                        wait();
                    }
                }
                restaurant.mealAtCheckOutCounter = new Meal(mealCounter--);

                if(mealCounter==0){
                    System.out.println("closing the restaurant (chef's run out of food)");
                    restaurant.close();
                }

                synchronized (restaurant.waiter){
                    System.out.println(this + " calling a waiter to claim the meal");
                    restaurant.waiter.notify();
                }
                System.out.println(this + " is smoking...");
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this+" has stopped working");
    }


}
