package com.codeHeap.threads.restaurantV2;

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
