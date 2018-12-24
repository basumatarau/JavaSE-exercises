package com.codeHeap.threads.optimization;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Atomic extends Accumulator {
    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    Atomic() {
        super("Atomic");
    }

    @Override
    public void accumulate() {
        int i = index.getAndIncrement();
        if(++i>=SIZE){
            index.set(0);
            return;
        }
        value.getAndAdd(preLoaded[i]);
    }

    @Override
    public long read() {
        return value.get();
    }
}
