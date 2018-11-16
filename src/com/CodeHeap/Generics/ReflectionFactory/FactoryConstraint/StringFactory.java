package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class StringFactory implements IFacotory<String>{
    @Override
    public String create() {
        //literal...
        return "generated string goes here...";
    }
}
