package com.CodeHeap.Generics.GenericArray.ArrayImpl1;

public class GenericArray {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    public static void main(String[] args) {
        //gia = (Generic<Integer>[]) new Object[SIZE];

        gia = new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());

        gia[0] = new Generic<>();
        System.out.println(gia[0].getClass().getSimpleName());
    }
}
