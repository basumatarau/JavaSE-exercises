package com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport;

public class FiveTuple<
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>,
        E extends Comparable<E>> extends FourTuple<A, B, C, D> {
    protected final E objE;

    public FiveTuple(A objA, B objB, C objC, D objD, E objE) {
        super(objA, objB, objC, objD);
        this.objE = objE;
    }

    @Override
    public int compareTo(TwoTuple<A, B> abcdeTuple) {
        int firstComparison = super.compareTo(abcdeTuple);
        if (firstComparison != 0) {
            return firstComparison;
        }
        FiveTuple<A, B, C, D, E> cast = (FiveTuple<A, B, C, D, E>) abcdeTuple;
        int secondComparison = objE.compareTo(cast.objE);
        if (secondComparison != 0) {
            return secondComparison;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + objE.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof FiveTuple)
                && (objA.equals(((FiveTuple) o).objA))
                && (objB.equals(((FiveTuple) o).objB))
                && (objC.equals(((FiveTuple) o).objC))
                && (objD.equals(((FiveTuple) o).objD))
                && (objE.equals(((FiveTuple) o).objE));
    }

    @Override
    public String toString() {
        return super.toString() + ", Fifth:" + objE;
    }
}
