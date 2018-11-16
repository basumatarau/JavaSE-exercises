package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class FactoryUser<T> {
    private T element;

    public <F extends IFacotory<T>> FactoryUser(F factoryObj){
        element = factoryObj.create();
    }

    public T getElement(){
        return element;
    }
}
