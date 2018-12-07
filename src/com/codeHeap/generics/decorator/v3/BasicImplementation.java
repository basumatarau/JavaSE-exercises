package com.codeHeap.generics.decorator.v3;


public class BasicImplementation implements Basic {
    private String value;

    public BasicImplementation() {
        value = "default string";
    }

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
