package com.CodeHeap.arrays.CountingGenerator;

import java.lang.reflect.Array;

public class Generated {
    public static <T> T[] fill(T[] array, Generator<T> generator){
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.next();
        }
        return array;
    }

    @SuppressWarnings("uncheked")
    public static <T> T[] fill(Class<T> type, Generator<T> generator, int size){
        T[] ts = (T[]) Array.newInstance(type, size);

        for (int i = 0; i < ts.length; i++) {
            ts[i] = generator.next();
        }
        return ts;
    }
}
