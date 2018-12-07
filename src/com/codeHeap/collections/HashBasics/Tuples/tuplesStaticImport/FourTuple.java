package com.codeHeap.collections.HashBasics.Tuples.tuplesStaticImport;

public class FourTuple<
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>,
        D extends Comparable<D>> extends ThreeTuple<A, B, C> {
    protected final D objD;

    public FourTuple(A objA, B objB, C objC, D objD) {
        super(objA, objB, objC);
        this.objD = objD;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fourth:" + objD;
    }

    @Override
    public int compareTo(TwoTuple<A, B> abcdTuple) {
        int firstComparison = super.compareTo(abcdTuple);
        if(firstComparison!=0){
            return firstComparison;
        }
        FourTuple<A,B,C,D> cast = (FourTuple<A,B,C,D>) abcdTuple;
        int secondComparison = objD.compareTo(cast.objD);
        if(secondComparison!=0){
            return secondComparison;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode()*37 + objD.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof FourTuple)
                && (objA.equals(((FourTuple) o).objA))
                && (objB.equals(((FourTuple) o).objB))
                && (objC.equals(((FourTuple) o).objC))
                && (objD.equals(((FourTuple) o).objD));
    }
}
