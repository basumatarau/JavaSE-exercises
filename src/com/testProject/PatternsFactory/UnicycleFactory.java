package com.testProject.PatternsFactory;

public class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}
