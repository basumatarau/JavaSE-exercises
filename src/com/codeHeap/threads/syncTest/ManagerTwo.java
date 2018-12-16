package com.codeHeap.threads.syncTest;

public class ManagerTwo extends PairManager {
    @Override
    public void increment() {
        synchronized (this){
            p.incrementX();
            p.incrementY();
        }
        store(getPair());
    }
}
