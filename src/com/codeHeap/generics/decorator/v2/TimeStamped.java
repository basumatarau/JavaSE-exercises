package com.codeHeap.generics.decorator.v2;

import java.util.Date;

public class TimeStamped extends Decorator{
    private final long timeStamp;
    private SerialNumbered serialNumbered;
    TimeStamped(Basic basic){
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getTimeStamp(){
        return timeStamp;
    }
}
