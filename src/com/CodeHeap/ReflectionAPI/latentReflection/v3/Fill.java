package com.CodeHeap.ReflectionAPI.latentReflection.v3;

import java.util.Collection;

public class Fill {
    public static <T> void fill(Collection<T> collection, Class<? extends T> type, int size){
        try {
            for (int i = 0; i < size; i++) {
                collection.add(type.newInstance());
            }
        }catch (IllegalAccessException | InstantiationException e){
            throw new RuntimeException(e);
        }
    }
}
