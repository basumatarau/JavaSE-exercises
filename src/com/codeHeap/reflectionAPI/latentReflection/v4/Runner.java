package com.codeHeap.reflectionAPI.latentReflection.v4;

import com.codeHeap.generics.generator.coffeeGenerator.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Coffee> coffees = new ArrayList<>();
        Fill2.fill(
                Fill2.collectionAdapter(coffees),
                Latte.class,
                5
        );
        Fill2.fill(
                Fill2.collectionAdapter(coffees),
                new Generator<Coffee>() {
                    @Override
                    public Coffee next() {
                        return new Mocha();
                    }
                },
                2
        );
        Fill2.fill(
                Fill2.collectionAdapter(coffees),
                ()->new Cappuccino(),
                3
        );
        Fill2.fill(
                Fill2.collectionAdapter(coffees),
                Breve::new,
                2
        );
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
