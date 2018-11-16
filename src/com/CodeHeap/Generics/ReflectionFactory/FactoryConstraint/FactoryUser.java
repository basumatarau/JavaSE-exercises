package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class FactoryUser<T> {
    private T element;

    public <F extends IFacotory<T>> FactoryUser(F factoryObj, Object... args){
        element = factoryObj.create(args);
    }

    public T getElement(){
        return element;
    }
}
