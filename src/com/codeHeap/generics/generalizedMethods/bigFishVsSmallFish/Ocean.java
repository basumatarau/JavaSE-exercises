package com.codeHeap.generics.generalizedMethods.bigFishVsSmallFish;

import com.codeHeap.generics.generalizedMethods.Generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ocean {
    static void realLifeLesson(BigFish bigFish, SmallFish smallFish) {
        System.out.println(bigFish + " has eaten " + smallFish);
    }

    public static void main(String[] args) {

        List<SmallFish> smallFishFlock = new ArrayList<>();
        Generators.fill(SmallFish.getGenerator(), smallFishFlock, 20);
        List<BigFish> bigFishFlock = new ArrayList<>();
        Generators.fill(BigFish.getGenerator(), bigFishFlock, 3);

        Random rand = new Random(47);
        for (SmallFish smallFish : smallFishFlock) {
            realLifeLesson(bigFishFlock.get(rand.nextInt(bigFishFlock.size())), smallFish);
        }

    }
}
