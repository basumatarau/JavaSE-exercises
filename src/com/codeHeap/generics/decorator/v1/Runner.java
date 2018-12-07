package com.codeHeap.generics.decorator.v1;

public class Runner {
    public static void main(String[] args) {
        Mixin mix1 = new Mixin(), mix2 = new Mixin();

        mix1.set("test1");
        mix2.set("test2");

        System.out.println(mix1.get() + ", " + mix1.getId() + ", " + mix1.getTimeStamp());
        System.out.println(mix2.get() + ", " + mix2.getId() + ", " + mix2.getTimeStamp());
    }
}
