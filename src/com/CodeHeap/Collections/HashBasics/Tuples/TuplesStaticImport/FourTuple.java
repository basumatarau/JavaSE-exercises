package com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    private final D objD;

    public FourTuple(A objA, B objB, C objC, D objD) {
        super(objA, objB, objC);
        this.objD = objD;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fourth:" + objD;
    }
}
