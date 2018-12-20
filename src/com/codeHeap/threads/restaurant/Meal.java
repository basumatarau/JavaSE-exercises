package com.codeHeap.threads.restaurant;

public class Meal {
    private final int id;

    Meal(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id;
    }
}
