package com.CodeHeap.patternsFactoryMethod;

public class TricycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}
