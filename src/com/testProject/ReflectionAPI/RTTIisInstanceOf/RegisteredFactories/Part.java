package com.testProject.ReflectionAPI.RTTIisInstanceOf.RegisteredFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {

    private static List<Factory<? extends Part>> register = new ArrayList<>();

    static {
        register.add(new AirFilter.Factory());
        register.add(new CabinAirFilter.Factory());
        register.add(new FanBelt.Factory());
        register.add(new FuelFilter.Factory());
        register.add(new GeneratoryBelt.Factory());
        register.add(new OilFilter.Factory());
    }

    private static Random rand = new Random(47);

    public static Part createRandomPart() {
        Factory<? extends Part> factory = register.get(rand.nextInt(register.size()));
        return factory.create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandomPart());
        }
    }
}
