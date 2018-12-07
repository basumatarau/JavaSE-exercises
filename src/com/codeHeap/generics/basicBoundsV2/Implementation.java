package com.codeHeap.generics.basicBoundsV2;

public class Implementation implements IOne, ITwo {
    @Override
    public void ofIOne() {
        System.out.println("implementation ofIOne from: "+this.getClass().getSimpleName());
    }

    @Override
    public void ofITwo() {
        System.out.println("implementation ofITwo from: "+this.getClass().getSimpleName());
    }

    static <T extends IOne> void methodOne(T obj){
        obj.ofIOne();
    }

    static <T extends ITwo> void methodTwo(T obj){
        obj.ofITwo();
    }

    public static void main(String[] args) {
        methodOne(new Implementation());
        methodTwo(new Implementation());
    }
}
