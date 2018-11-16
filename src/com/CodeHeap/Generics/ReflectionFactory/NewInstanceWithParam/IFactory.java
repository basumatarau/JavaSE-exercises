package com.CodeHeap.Generics.ReflectionFactory.NewInstanceWithParam;

public interface IFactory<T> {
    Object create();
    Object create(Object... param);
}
