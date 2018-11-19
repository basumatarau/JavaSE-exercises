package com.CodeHeap.ReflectionAPI.latentReflection.v4;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Generator;

import java.util.Collection;

public class Fill2 {

    public static <T> void fill(Addable<T> addable, Class<? extends T> type, int size){
        try {
            for (int i = 0; i < size; i++) {
                addable.add(type.newInstance());
            }
        }catch (InstantiationException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size){
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }
    }

    public static <T> AddableCollectionAdapter<T> collectionAdapter(Collection<T> collection){
        return new AddableCollectionAdapter<>(collection);
    }

}
