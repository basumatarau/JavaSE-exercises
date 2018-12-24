package com.codeHeap.threads.optimization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Accumulator {
    private Lock lock = new ReentrantLock();

    @Override
    public void accumulate() {
        lock.lock();
        try{
            //nonatomic increment on volatile field within synchronized block, hence:
            //noinspection NonAtomicOperationOnVolatileField
            value += preLoaded[index++];
            if(index>=SIZE){
                index = 0;
            }
        }finally{
            lock.unlock();
        }
    }

    @Override
    public long read() {
        lock.lock();
        try {
            return value;
        }finally{
            lock.unlock();
        }
    }

    LockTest() {
        super("LockTest");
    }
}
