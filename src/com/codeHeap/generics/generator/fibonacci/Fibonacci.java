package com.codeHeap.generics.generator.fibonacci;

import com.codeHeap.generics.generator.coffeeGenerator.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    protected int fibonacci(int n){
        if(n < 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    @Override
    public Integer next() {
        return fibonacci(count++);
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.print(" "+fib.next());
        }
    }
}
