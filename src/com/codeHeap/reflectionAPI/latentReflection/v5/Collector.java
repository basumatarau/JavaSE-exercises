package com.codeHeap.reflectionAPI.latentReflection.v5;

public interface Collector<T> extends UnaryFunction<T,T>{
    T collect();
}
