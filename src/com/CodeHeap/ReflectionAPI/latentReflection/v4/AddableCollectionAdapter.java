package com.CodeHeap.ReflectionAPI.latentReflection.v4;

import java.util.Collection;

public class AddableCollectionAdapter <T> implements Addable<T> {

    private Collection<T> collection;
    AddableCollectionAdapter(Collection<T> collection){
        this.collection = collection;
    }

    @Override
    public void add(T obj) {
        collection.add(obj);
    }
}
