package com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport;

public class ThreeTuple <
        A extends Comparable<A>,
        B extends Comparable<B>,
        C extends Comparable<C>> extends TwoTuple<A,B> {

    protected final C objC;

    public ThreeTuple(A objA, B objB, C objC) {
        super(objA, objB);
        this.objC = objC;
    }

    @Override
    public int compareTo(TwoTuple<A, B> abcTuple) {
        int firstComparison = super.compareTo(abcTuple);
        if(firstComparison!=0){
            return firstComparison;
        }
        //wow wow wow something's wrong here...
        ThreeTuple<A, B, C> cast = (ThreeTuple<A, B, C>) abcTuple;
        int secondComparison = objC.compareTo(cast.objC);
        if(secondComparison!=0){
            return secondComparison;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + objC.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof ThreeTuple)
                && (objA.equals(((ThreeTuple)o).objA))
                && (objB.equals(((ThreeTuple)o).objB))
                && (objC.equals(((ThreeTuple)o).objC));
    }

    @Override
    public String toString() {
        return super.toString()+", Third: "+ objC;
    }
}
