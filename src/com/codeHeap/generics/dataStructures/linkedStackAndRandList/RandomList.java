package com.codeHeap.generics.dataStructures.linkedStackAndRandList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {
    private List<T> storage = new ArrayList<>();
    private Random random = new Random(47);

    public void add(T obj){
        storage.add(obj);
    }

    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }
    public int size(){
        return storage.size();
    }
}
