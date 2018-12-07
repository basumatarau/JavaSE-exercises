package com.codeHeap.patternsFactoryMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        CycleFactory[] factories = {
                new UnicycleFactory(),
                new BicycleFactory(),
                new TricycleFactory()
        };

        List<Cycle> cycles = new ArrayList<>();

        Random rand = new Random(47L);
        for (int i = 0; i < 10; i++) {
            Cycle cycle = factories[rand.nextInt(factories.length)].getCycle();
            cycles.add(cycle);
        }

        for (Cycle cycle : cycles) {
            cycle.ride();
        }
    }
}
