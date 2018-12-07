package com.codeHeap.arrays.sort;

import com.codeHeap.arrays.CountingGenerator.Generated;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        CompType[] a = Generated.fill(CompType.class, CompType.getGenerator(), 11);
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, (ob1, ob2)->ob1.i < ob2.i ? -1 : (ob1.i == ob2.i ? 0 : 1));
        Arrays.sort(a, (o1, o2)->Integer.compare(o1.i, o2.i));

    }
}
