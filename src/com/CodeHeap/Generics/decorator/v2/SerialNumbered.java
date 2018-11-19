package com.CodeHeap.Generics.decorator.v2;

public class SerialNumbered extends Decorator {
    private static int counter = 0;
    private final int id;

    SerialNumbered(Basic basic){
        super(basic);
        id = ++counter;
    }
    public int getId(){
        return id;
    }
}
