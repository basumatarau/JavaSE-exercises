package com.codeHeap.threads.bankTellerSimulation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CustomerGenerator implements Runnable {

    private CustomerLine line;
    private static Random random = new Random(47);

    CustomerGenerator(CustomerLine line){
        this.line = line;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(250);
                line.add(new Customer(random.nextInt(1000)));
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
