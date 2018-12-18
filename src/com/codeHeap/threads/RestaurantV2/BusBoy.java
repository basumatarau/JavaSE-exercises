package com.codeHeap.threads.RestaurantV2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BusBoy extends Employee implements Runnable {
    private Restaurant restaurant;
    private Lock busBoyLock = new ReentrantLock();
    private Condition busBoyCondition = busBoyLock.newCondition();

    public Condition getBusBoyCondition(){
        return busBoyCondition;
    }
    public Lock getBusBoyLock(){
        return busBoyLock;
    }

    BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                busBoyLock.lock();
                try{
                    if (!restaurant.needCleanUp) {
                        busBoyCondition.await();
                    }
                }finally{
                    busBoyLock.unlock();
                }

                System.out.println(this + " is cleaning up...");
                TimeUnit.MILLISECONDS.sleep(60);

                restaurant.waiter.getWaiterLock().lock();
                try{
                    restaurant.needCleanUp = false;
                    System.out.println(this + " has finished cleaning up");
                }finally{
                    restaurant.waiter.getWaiterLock().unlock();
                }
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }

        System.out.println(this + " has finished working");
    }
}
