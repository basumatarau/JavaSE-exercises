package com.codeHeap.threads.producerAndConsumer;

public class Product {
    private final int id = ++counter;
    private static int counter = 0;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id;
    }
}
