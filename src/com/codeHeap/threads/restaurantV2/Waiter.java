package com.codeHeap.threads.restaurantV2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter extends Employee implements Runnable {
    private Restaurant restaurant;
    private Meal beingServed;

    private Lock waiterLock = new ReentrantLock();
    private Condition waiterCondition = waiterLock.newCondition();

    public Condition getWaiterCondition(){
        return waiterCondition;
    }
    public Lock getWaiterLock(){
        return waiterLock;
    }

    Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                waiterLock.lock();
                try{
                    while(restaurant.mealAtCheckOutCounter==null){
                        waiterCondition.await();
                    }
                }finally {
                    waiterLock.unlock();
                }

                restaurant.chef.getChefLock().lock();
                try{
                    beingServed = restaurant.mealAtCheckOutCounter;
                    restaurant.mealAtCheckOutCounter = null;
                    System.out.println(beingServed + " being served by " + this);
                }finally{
                    restaurant.chef.getChefLock().unlock();
                }

                TimeUnit.MILLISECONDS.sleep(50);

                restaurant.busBoy.getBusBoyLock().lock();
                try{
                    restaurant.needCleanUp = true;
                    restaurant.busBoy.getBusBoyCondition().signal();
                    System.out.println(this + " is telling a busboy to clean up");
                }finally{
                    restaurant.busBoy.getBusBoyLock().unlock();
                }
                System.out.println(this + " is ready to serve another meal");
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " has stopped working");
    }

}
