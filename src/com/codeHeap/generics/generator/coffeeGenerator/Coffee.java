package com.codeHeap.generics.generator.coffeeGenerator;

public class Coffee {
    private static int counter=0;
    private final int id = ++counter;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " id:"+ id;
    }
}
