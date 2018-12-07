package com.codeHeap.generics.generalizedMethods.bigFishVsSmallFish;

import com.codeHeap.generics.generator.coffeeGenerator.Generator;

public class SmallFish {
    private static int counter = 1;
    private final int id = counter++;

    private SmallFish() {
    }

    public static Generator<SmallFish> getGenerator() {
        return SmallFish::new;
    }

    @Override
    public String toString() {
        return "small poor fish buddy#" + id;
    }
}
