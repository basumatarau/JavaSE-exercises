package com.codeHeap.threads.carBuilder;

import java.util.concurrent.BrokenBarrierException;

public abstract class Robot implements Runnable {
    Assembler assembler;
    private RobotPool robotPool;

    Robot(RobotPool robotPool){
        this.robotPool = robotPool;
    }

    void assignAssembler(Assembler assembler){
        this.assembler = assembler;
    }

    private boolean isEngaged = false;
    synchronized void setEngaged(){
        isEngaged = true;
        notifyAll();
    }

    protected abstract void performService();

    @Override
    public void run() {
        try{
            powerDown();
            while(!Thread.interrupted()){
                performService();
                assembler.getBarrier().await();
                powerDown();
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }catch (BrokenBarrierException e){
            throw new RuntimeException(e);
        }
        System.out.println(this + " has been turned off");
    }

    private synchronized void powerDown() throws InterruptedException{
        isEngaged = false;
        assembler = null;
        robotPool.release(this);

        while(!isEngaged){
            System.out.println("is waiting");
            wait();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
