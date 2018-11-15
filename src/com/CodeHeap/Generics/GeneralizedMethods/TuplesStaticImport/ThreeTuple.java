package com.CodeHeap.Generics.GeneralizedMethods.TuplesStaticImport;

public class ThreeTuple <A,B,C> extends TwoTuple<A,B> {
    private final C objC;

    public ThreeTuple(A objA, B objB, C objC) {
        super(objA, objB);
        this.objC = objC;
    }

    @Override
    public String toString() {
        return super.toString()+", Third: "+ objC;
    }
}
