package com.CodeHeap.Generics.InterfaceHijack;

public class ComparisonTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        System.out.println(cat1.compareTo(cat2));
    }
}
