package com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport;

public class TwoTuple<A, B> implements Comparable<TwoTuple<A,B>> {
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

    @Override
    public int compareTo(TwoTuple<A, B> abTwoTuple) {
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
