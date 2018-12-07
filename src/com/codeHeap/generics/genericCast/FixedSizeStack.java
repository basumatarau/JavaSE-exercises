package com.codeHeap.generics.genericCast;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeStack<T> {
    private int index = 0;
    private List<T> storage;

    public FixedSizeStack(int size){
        storage = new ArrayList<>();
    }

    public void push(T item){
        storage.add(index++, item);
    }
    public T pop(){
        return storage.get(--index);
    }
}
