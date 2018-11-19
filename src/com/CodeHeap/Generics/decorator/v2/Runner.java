package com.CodeHeap.Generics.decorator.v2;

public class Runner {
    public static void main(String[] args) {
        TimeStamped ts = new TimeStamped(new Basic());
        TimeStamped ts2 = new TimeStamped(new SerialNumbered(new Basic()));

        System.out.println(ts2.getTimeStamp());

        SerialNumbered sn1 = new SerialNumbered(new Basic());
        SerialNumbered sn2 = new SerialNumbered(new TimeStamped(new Basic()));

        System.out.println(sn2.getId());
    }
}
