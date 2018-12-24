package com.codeHeap.threads.optimization;

public class Synchronized extends Accumulator {
    Synchronized() {
        super("Synchronized");
    }

    @Override
    synchronized public void accumulate() {
        value += preLoaded[index++];
        if(index >= SIZE){
            index = 0;
        }
    }

    @Override
    synchronized public long read() {
        return value;
    }
}
