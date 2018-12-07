package com.codeHeap.arrays.task16_8;

public class ArrayGenericType<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    ArrayGenericType(int size){
        array = (T[])new Object[size];
        //array = new T[size];
    }

    //public <U> U[] makeArray(int size){return new U[size];}
}
