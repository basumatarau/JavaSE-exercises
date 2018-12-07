package com.codeHeap.reflectionAPI.latentReflection.v3;

public class Contract {
    private static int counter = 0;
    private final int id = ++counter;

    @Override
    public String toString() {
        return getClass().getSimpleName()+id;
    }
}
