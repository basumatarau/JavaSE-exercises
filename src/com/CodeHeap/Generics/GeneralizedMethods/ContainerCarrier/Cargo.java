package com.CodeHeap.Generics.GeneralizedMethods.ContainerCarrier;

import com.CodeHeap.Generics.Generator.CoffeeGenerator.Generator;

import java.text.NumberFormat;
import java.util.Random;

public class Cargo {
    private static int count = 1;
    private final int ID = count++;

    private String name;
    private String description;
    private Double weight;


    private static Random rand = new Random(47);

    public Cargo(String name, String description, Double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "cargo#" + ID + ", name: " + name + ", weight:" +weight + "kg.";
    }

    public static Generator<Cargo> getGenerator(){
        return ()->{
            String[] names = {
                    "potatoes",
                    "cabbages",
                    "crude oil",
                    "automobile parts",
                    "slaves"
            };

            return new Cargo(
                    names[rand.nextInt(names.length)],
                    "test description",
                    Math.round(rand.nextDouble()*1000)+0.99
            );

        };
    }
}
