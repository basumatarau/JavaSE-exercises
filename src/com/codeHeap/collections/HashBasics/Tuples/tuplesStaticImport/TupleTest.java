package com.codeHeap.collections.HashBasics.Tuples.tuplesStaticImport;

import java.util.ArrayList;
import java.util.List;

import static com.codeHeap.collections.HashBasics.Tuples.tuplesStaticImport.Tuple.tuple;

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

        List<TwoTuple<Integer, Integer>> abTuplesIntInt = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            abTuplesIntInt.add(tuple(i,i));
        }
        abTuplesIntInt.add(tuple(3,3));
        System.out.println(abTuplesIntInt);
        abTuplesIntInt.sort(TwoTuple::compareTo);
        System.out.println(abTuplesIntInt);

    }
}
