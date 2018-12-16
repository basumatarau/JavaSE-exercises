package com.codeHeap.threads.syncTest;

public class PairManipulator implements Runnable {

    PairManager pm;
    PairManipulator(PairManager pm){
        this.pm = pm;
    }

    @Override
    public void run() {
        while(true){
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "Pair: " + pm.p + ", checkCounter: " + pm.checkCounter.get();
    }
}
