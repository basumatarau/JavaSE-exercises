package com.testProject.test0001;

public class SomeClass implements InterfaceC, InterfaceB {
    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        sc.print();

    }
    public void print(){
        System.out.println("method called by instance of "+getClass().getSimpleName());
    }
}
