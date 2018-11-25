package com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport;

public class Tuple {
    public static <
            A extends Comparable<A>,
            B extends Comparable<B>> TwoTuple<A, B> tuple(A a, B b){
        return new TwoTuple<>(a, b);
    }
    public static <
            A extends Comparable<A>,
            B extends Comparable<B>,
            C extends Comparable<C>> ThreeTuple<A,B,C> tuple(A a, B b, C c){
        return new ThreeTuple<>(a, b, c);
    }
    public static <
            A extends Comparable<A>,
            B extends Comparable<B>,
            C extends Comparable<C>,
            D extends Comparable<D>> FourTuple<A, B, C, D> tuple (A a, B b, C c, D d){
        return new FourTuple<>(a, b, c, d);
    }
    public static <
            A extends Comparable<A>,
            B extends Comparable<B>,
            C extends Comparable<C>,
            D extends Comparable<D>,
            E extends Comparable<E>> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e){
        return new FiveTuple<>(a, b, c, d, e);
    }
}
