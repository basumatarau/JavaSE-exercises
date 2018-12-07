package com.codeHeap.generics.reflectionFactory.newInstanceWithParam;

public interface IFactory<T> {
    Object create();
    Object create(Object... param);
}
