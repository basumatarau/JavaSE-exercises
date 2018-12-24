package com.codeHeap.threads.CarBuilder;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Assembler implements Runnable{
    private CarQueue chassisQueue, finishingQueue;
    private RobotPool robotPool;
    private Car car;
    //3 operations + 1 assembler task
    private CyclicBarrier barrier = new CyclicBarrier(4);

    Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool){
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }
    public CyclicBarrier getBarrier(){
        return barrier;
    }
    public Car getTheCar(){
        return car;
    }
    @Override
    public void run() {
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
            while (!Thread.interrupted()){
                car = chassisQueue.take();

                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);

                barrier.await();
                finishingQueue.put(car);
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        System.out.println(this + " has finished working");
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
