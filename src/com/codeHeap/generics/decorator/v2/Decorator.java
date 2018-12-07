package com.codeHeap.generics.decorator.v2;

public class Decorator extends Basic {
    protected Basic basicInstance;

    Decorator(Basic basic) {
        basicInstance = basic;
    }

    @Override
    public String get() {
        return basicInstance.get();
    }

    @Override
    public void set(String value) {
        basicInstance.set(value);
    }
}
