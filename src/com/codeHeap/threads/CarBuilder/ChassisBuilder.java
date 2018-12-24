package com.codeHeap.threads.CarBuilder;

import java.util.concurrent.TimeUnit;

public class ChassisBuilder implements Runnable {

    private CarQueue carQueue;
    private int counter = 0;
    public ChassisBuilder(CarQueue carQueue){
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(500);
                Car car = new Car(++counter);
                System.out.println(this + " created " + car);
                carQueue.put(car);
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " has finished working");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
