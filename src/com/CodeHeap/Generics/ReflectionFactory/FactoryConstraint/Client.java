package com.CodeHeap.Generics.ReflectionFactory.FactoryConstraint;

public class Client {
    public static void main(String[] args) {

        System.out.println((new FactoryUser<>(new StringFactory()).getElement()));

        System.out.println((new FactoryUser<>(new IntegerFactory()).getElement()));
    }
}
