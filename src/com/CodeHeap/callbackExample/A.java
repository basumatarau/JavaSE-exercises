package com.CodeHeap.callbackExample;

public class A {
    private static int count = 0;
    private final int ID = ++count;

    public U makeU() {
        return new U() {
            @Override
            public void firstMethod() {
                System.out.println("firstMethod of U instance#" + ID + " has been invoked");
            }

            @Override
            public void secondMethod() {
                System.out.println("secondMethod of U instance#" + ID + " has been invoked");
            }

            @Override
            public void thirdMethod() {
                System.out.println("thirdMethod of U instance#" + ID + " has been invoked");
            }

        };
    }
}
