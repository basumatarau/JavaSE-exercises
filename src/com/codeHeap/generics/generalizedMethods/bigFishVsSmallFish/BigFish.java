package com.codeHeap.generics.generalizedMethods.bigFishVsSmallFish;

import com.codeHeap.generics.generator.coffeeGenerator.Generator;

public class BigFish {
    private static int counter = 1;
    private final int id = counter++;

    private BigFish() {
    }

    public static Generator<BigFish> getGenerator() {
        return ()->new BigFish();
    }

    @Override
    public String toString() {
        return "BigFish#" + id;
    }
}
