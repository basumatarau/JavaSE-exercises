package com.codeHeap.threads.syncTest;

public class ManagerOne extends PairManager {
    @Override
    synchronized public void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
