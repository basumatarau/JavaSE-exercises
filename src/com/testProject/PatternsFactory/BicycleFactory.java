package com.testProject.PatternsFactory;

public class BicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}
