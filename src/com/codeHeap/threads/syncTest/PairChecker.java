package com.codeHeap.threads.syncTest;

public class PairChecker implements Runnable{

    PairManager pm;
    PairChecker(PairManager pm){
        this.pm = pm;
    }

    @Override
    public void run() {
        while(true){
            pm.checkCounter.getAndIncrement();
            pm.getPair().checkState();
        }
    }
}
