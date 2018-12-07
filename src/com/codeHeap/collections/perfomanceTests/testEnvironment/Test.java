package com.codeHeap.collections.perfomanceTests.testEnvironment;

public abstract class Test<C> {
    String name;
    public Test(String name){
        this.name = name;
    }
    public abstract int test(C container, TestParam param);
}
