package com.CodeHeap.Generics.GeneralizedMethods.BigFishVsSmallFish;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Generator;

public class SmallFish {
    private static int counter = 1;
    private final int id = counter++;

    private SmallFish() {
    }

    public static Generator<SmallFish> getGenerator() {
        return new Generator<SmallFish>() {
            @Override
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }

    @Override
    public String toString() {
        return "small poor fish buddy#" + id;
    }
}
