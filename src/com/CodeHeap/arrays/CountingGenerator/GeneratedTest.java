package com.CodeHeap.arrays.CountingGenerator;

import java.math.BigDecimal;
import java.util.Arrays;

public class GeneratedTest {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4};
        System.out.println(Arrays.toString(a));
        a = Generated.fill(Integer.class, new RandomGenerator.Integer(), 5);
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.fill(Integer.class, new RandomGenerator.Integer(), 10);
        System.out.println(Arrays.toString(b));

        Integer[] c = {4,5,6,7};
        System.out.println(Arrays.toString(c));
        int[] d = ConvertTo.primitive(c);
        System.out.println(Arrays.toString(d));

        boolean[] e = ConvertTo.primitive(
                Generated.fill(Boolean.class, new RandomGenerator.Boolean(), 5)
        );

        System.out.println(Arrays.toString(e));

        Boolean[] f = Generated.fill(Boolean.class, new RandomGenerator.Boolean(), 4);
        System.out.println(Arrays.toString(f));
        //boolean[] g = f;
        BigDecimal[] db = Generated.fill(BigDecimal.class, new Generator<BigDecimal>() {
            private BigDecimal value = BigDecimal.TEN;
            @Override
            public BigDecimal next() {
                return value=value.add(BigDecimal.ONE);
            }
        }, 5);
        System.out.println(Arrays.toString(db));
    }
}
