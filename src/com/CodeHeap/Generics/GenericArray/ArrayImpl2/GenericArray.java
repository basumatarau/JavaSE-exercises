package com.CodeHeap.Generics.GenericArray.ArrayImpl2;

public class GenericArray<T> {
    private T[] array;
    public GenericArray(int size){
        array = (T[]) new Object[size];
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] represent(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);

        Integer[] a = gai.represent();

        Object[] b = gai.represent();

    }
}
