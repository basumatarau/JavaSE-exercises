package com.codeHeap.reflectionAPI.latentReflection.v2;

public class Shape {
    public void rotate() {
        System.out.println("rotating " + this.getClass().getSimpleName());
    }

    public void resize(int newSize) {
        System.out.println("resizing " + this.getClass().getSimpleName() + " to new size: " + newSize);
    }
}
