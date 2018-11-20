package com.CodeHeap.ReflectionAPI.latentReflection.v5;

public interface Collector<T> extends UnaryFunction<T,T>{
    T collect();
}
