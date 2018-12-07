package com.codeHeap.generics.reflectionFactory.factoryConstraint;

public interface IFacotory<T> {
    T create(Object... args);
}
