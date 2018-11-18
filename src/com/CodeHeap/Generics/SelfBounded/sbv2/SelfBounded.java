package com.CodeHeap.Generics.SelfBounded.sbv2;

public abstract class SelfBounded<T extends SelfBounded<T>> {
    T element;
    public abstract T setAndGet(T obj);
    public T invoker(T obj){
        return setAndGet(obj);
    }
}
