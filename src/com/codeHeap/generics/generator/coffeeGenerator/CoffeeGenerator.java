package com.codeHeap.generics.generator.coffeeGenerator;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{

    private Random random = new Random(47);
    @SuppressWarnings("unchecked")
    private Class<? extends Coffee>[] coffeeTypes = new Class[]{
            Americano.class,
            Breve.class,
            Cappuccino.class,
            Latte.class,
            Mocha.class
    };
    private int size = 0;

    public CoffeeGenerator(){}
    public CoffeeGenerator(int size){
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return coffeeTypes[random.nextInt(coffeeTypes.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return size>count;
            }

            @Override
            public Coffee next() {
                count++;
                return CoffeeGenerator.this.next();
            }
        };
    }
}
