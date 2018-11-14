package com.CodeHeap.Generics.Generator.Fibonacci;

import java.util.Iterator;

public class AdaptedFibonacciV2 implements Iterable<Integer> {
    private int count;
    public AdaptedFibonacciV2(int count){
        this.count = count;
    }
    private Fibonacci fibonacci = new Fibonacci();;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            private int i = count;
            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public Integer next() {
                i--;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        AdaptedFibonacciV2 fibonacci = new AdaptedFibonacciV2(20);
        for (Integer integer : fibonacci) {
            System.out.println(integer);
        }
    }
}
