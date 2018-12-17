package com.codeHeap.threads.OrnamentalGarden;

import java.util.Random;

public class Count {
    private int count = 0;

    private Random rand = new Random(47);
    public synchronized int increment(){

        int temp = count;

        if(rand.nextBoolean()){
            Thread.yield();
        }

        return (count = ++temp);
    }

    public int value(){
        return count;
    }
}
