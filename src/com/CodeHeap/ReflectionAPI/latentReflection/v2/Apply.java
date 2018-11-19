package com.CodeHeap.ReflectionAPI.latentReflection.v2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Apply {
    public static <T, S extends Iterable<T>> void apply(S list, Method method, Object... args){
        for (T item : list) {
            try{
                method.invoke(item, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
