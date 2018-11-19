package com.CodeHeap.Generics.decorator.v1;

public class Mixin extends BasicImplementation implements SerialNumbered, TimeStamped  {
    private TimeStamped stamp = new StampedImplementation();
    private SerialNumbered numbered = new NumberedImplementation();

    @Override
    public int getId() {
        return numbered.getId();
    }

    @Override
    public long getTimeStamp() {
        return stamp.getTimeStamp();
    }

}
