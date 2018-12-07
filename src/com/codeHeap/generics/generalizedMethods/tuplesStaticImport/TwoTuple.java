package com.codeHeap.generics.generalizedMethods.tuplesStaticImport;

public class TwoTuple<A, B> {
    private final A objA;
    private final B objB;

    public TwoTuple(A objA, B objB) {
        this.objA = objA;
        this.objB = objB;
    }

    @Override
    public String toString() {
        return "First: " + objA + ", Second: " + objB;
    }
}
