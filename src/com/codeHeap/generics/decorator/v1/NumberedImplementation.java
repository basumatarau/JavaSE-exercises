package com.codeHeap.generics.decorator.v1;

public class NumberedImplementation implements SerialNumbered {
    private static int counter = 0;
    private final int id;

    NumberedImplementation() {
        id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }
}
