package com.codeHeap.generics.generalizedMethods.tuplesStaticImport;

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    private final E objE;

    public FiveTuple(A objA, B objB, C objC, D objD, E objE) {
        super(objA, objB, objC, objD);
        this.objE = objE;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fifth:" + objE;
    }
}
