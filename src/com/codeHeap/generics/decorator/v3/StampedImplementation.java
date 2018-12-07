package com.codeHeap.generics.decorator.v3;

import java.util.Date;

public class StampedImplementation implements TimeStamped {
    private final long timestamp;

    StampedImplementation() {
        timestamp = new Date().getTime();
    }

    @Override
    public long getTimeStamp() {
        return timestamp;
    }
}
