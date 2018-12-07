package com.codeHeap.patternsFactoryMethod;

public class TricycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}
