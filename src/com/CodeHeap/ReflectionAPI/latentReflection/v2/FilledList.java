package com.CodeHeap.ReflectionAPI.latentReflection.v2;

import java.util.ArrayList;

public class FilledList<T> extends ArrayList<T> {
    FilledList(Class<? extends T> cl, int size){
        try {
            for (int i = 0; i < size; i++) {
                add(cl.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
