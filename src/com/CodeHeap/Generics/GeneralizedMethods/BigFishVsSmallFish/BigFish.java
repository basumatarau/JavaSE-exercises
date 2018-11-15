package com.CodeHeap.Generics.GeneralizedMethods.BigFishVsSmallFish;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Generator;

public class BigFish {
    private static int counter = 1;
    private final int id = counter++;

    private BigFish() {
    }

    public static Generator<BigFish> getGenerator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }

    @Override
    public String toString() {
        return "BigFish#" + id;
    }
}
