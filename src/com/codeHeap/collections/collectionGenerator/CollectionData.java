package com.codeHeap.collections.collectionGenerator;

import com.codeHeap.arrays.CountingGenerator.Generator;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> generator, int size){
        for (int i = 0; i < size; i++) {
            add(generator.next());
        }
    }

    public static <T> ArrayList<T> list(Generator<T> generator, int size){
        return new CollectionData<>(generator, size);
    }
}
