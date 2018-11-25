package com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport;

import static com.CodeHeap.Collections.HashBasics.Tuples.TuplesStaticImport.Tuple.tuple;

public class TupleTest {
    static TwoTuple<Integer, String> f() {
        return tuple(1, "one");
    }

    static TwoTuple f2() {
        return tuple(1, "one");
    }

    public static void main(String[] args) {
        TwoTuple<Integer, String> ttis = f();

        System.out.println(ttis);
        System.out.println(f2());

        @SuppressWarnings("unchcked")
        TwoTuple<String, String> ttss = f2();
        System.out.println(ttss);
    }
}
