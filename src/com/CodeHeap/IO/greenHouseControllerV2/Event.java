package com.CodeHeap.IO.greenHouseControllerV2;

public abstract class Event {
    protected long delayTime;
    protected long eventTime;

    Event(long delayTime) {
        this.delayTime = delayTime * 1000000;
        start();
    }

    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return eventTime < System.nanoTime();
    }

    public abstract void action();
}
