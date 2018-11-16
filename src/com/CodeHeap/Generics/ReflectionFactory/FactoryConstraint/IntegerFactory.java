package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class IntegerFactory implements IFacotory<Integer> {
    @Override
    public Integer create() {
        //autoboxing...
        return 1234;
    }
}
