package com.testProject.callbackExample;

public class Runner {
    public static void main(String[] args) {
        B b = new B();
        for (int i = 0; i < 10; i++) {
            U u = new A().makeU();
            b.addU(u);
        }

        b.invokeAll();
    }
}
