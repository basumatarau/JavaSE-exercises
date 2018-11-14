package com.CodeHeap.Generics.Generator.Fibonacci;

import java.util.Iterator;

public class AdaptedFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public AdaptedFibonacci(int count) {
        this.n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return AdaptedFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        AdaptedFibonacci fibonacci = new AdaptedFibonacci(20);
        for (Integer integer : fibonacci) {
            System.out.println(integer);
        }
    }
}
