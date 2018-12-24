package com.codeHeap.threads.CarBuilder;

public class Reporter implements Runnable {

    private CarQueue reportedQueue;

    Reporter(CarQueue carQueue){
        reportedQueue = carQueue;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                Car car = reportedQueue.take();
                System.out.println(this + " reporting new " + car);
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
