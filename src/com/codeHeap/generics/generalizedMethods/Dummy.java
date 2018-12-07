package com.codeHeap.generics.generalizedMethods;

public class Dummy {
    private static int count = 1;
    private final int id;

    Dummy() {
        id = count++;
    }

    @Override
    public String toString() {
        return "Dummy instance#" + id;
    }
}
