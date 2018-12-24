package com.codeHeap.threads.optimization;

public class BaseLine extends Accumulator {
    BaseLine() {
        super("BaseLine");
    }

    @Override
    public void accumulate() {
        if(index>=SIZE){
            index = 0;
            return;
        }
        //baseline test compares performance of nonblocking operations against synchronized, hence:
        //noinspection NonAtomicOperationOnVolatileField
        value += preLoaded[index++];
    }

    @Override
    public long read() {
        return value;
    }
}
