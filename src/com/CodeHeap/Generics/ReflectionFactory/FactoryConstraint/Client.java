package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class Client {
    public static void main(String[] args) {

        System.out.println((new FactoryUser<>(new StringFactory(), "this is a Test string".split(" ")).getElement()));

        System.out.println((new FactoryUser<>(new IntegerFactory(), 1,2,3,4,5).getElement()));
    }
}
