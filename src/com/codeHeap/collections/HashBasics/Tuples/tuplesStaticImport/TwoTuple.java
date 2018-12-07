package com.codeHeap.collections.HashBasics.Tuples.tuplesStaticImport;

public class TwoTuple<A extends Comparable<A>, B extends Comparable<B>>
        implements Comparable<TwoTuple<A, B>> {
    protected final A objA;
    protected final B objB;

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
        int firsComparison = objA.compareTo(abTwoTuple.objA);
        if(firsComparison!=0){
            return firsComparison;
        }
        int secondComparison = objB.compareTo(abTwoTuple.objB);
        if(secondComparison!=0){
            return secondComparison;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result *37 + objA.hashCode();
        result = result *37 + objB.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof TwoTuple)
                && (objA.equals(((TwoTuple) o).objA))
                && (objB.equals(((TwoTuple) o).objB));
    }
}
