package com.testProject.PatternsFactory;

public class TricycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}
