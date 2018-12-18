package com.codeHeap.threads.RestaurantV2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chef extends Employee implements Runnable {
    private Restaurant restaurant;
    private int mealCounter = 10;

    private Lock chefLock = new ReentrantLock();
    private Condition chefCondition = chefLock.newCondition();
    public Condition getChefCondition(){
        return chefCondition;
    }
    public Lock getChefLock(){
        return chefLock;
    }

    Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){

                chefLock.lock();
                try {
                    while (restaurant.mealAtCheckOutCounter != null) {
                        System.out.println(this + " is waiting for the meal to be claimed");
                        chefCondition.await();
                    }
                }finally{
                    chefLock.unlock();
                }

                restaurant.mealAtCheckOutCounter = new Meal(mealCounter--);

                if(mealCounter==0){
                    System.out.println("closing the restaurant (chef's run out of food)");
                    restaurant.close();
                }

                restaurant.waiter.getWaiterLock().lock();
                try{
                    System.out.println(this + " calling a waiter to claim the meal");
                    restaurant.waiter.getWaiterCondition().signal();
                }finally {
                    restaurant.waiter.getWaiterLock().unlock();
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
