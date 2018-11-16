package com.CodeHeap.Generics.BasicBounds;

public class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoises() {
        System.out.println(this.getClass().getSimpleName()+" is listening carefully...");
    }

    @Override
    public void trackBySmell() {
        System.out.println(this.getClass().getSimpleName()+" is tracking somebody by smell...");
    }
}
