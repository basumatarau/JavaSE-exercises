package com.codeHeap.io.greenHouseController;

public abstract class Event {
    protected long delayTime;
    private long eventTime;

    public Event(long delayTime) {
        this.delayTime = 1000000 * delayTime;
        start();
    }

    public void start() {
        this.eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();

}
