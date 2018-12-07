package com.codeHeap.generics.selfBounded.sbv1;

public class SelfBounded <T extends SelfBounded<T>> {
    T instance;
    public void set(T obj){
        instance = obj;
    }
    T get(){
        return instance;
    }
}
