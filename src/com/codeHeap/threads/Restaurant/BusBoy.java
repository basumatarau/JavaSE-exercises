package com.codeHeap.threads.Restaurant;

import java.util.concurrent.TimeUnit;

public class BusBoy extends Employee implements Runnable {
    private Restaurant restaurant;

    BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized (this) {
                    if (!restaurant.needCleanUp) {
                        wait();
                    }
                }
                System.out.println(this + " is cleaning up...");
                TimeUnit.MILLISECONDS.sleep(60);

                synchronized (restaurant.waiter) {
                    restaurant.needCleanUp = false;
                    System.out.println(this + " has finished cleaning up");
                }
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }

        System.out.println(this + " has finished working");
    }
}
