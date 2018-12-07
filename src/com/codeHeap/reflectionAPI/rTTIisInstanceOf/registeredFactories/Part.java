package com.codeHeap.reflectionAPI.rTTIisInstanceOf.registeredFactories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Part {

    private static List<Class<? extends Part>> register = new ArrayList<>();

    public static class NullPart extends Part implements Null{

    }

    static {
        register.add(AirFilter.class);
        register.add(CabinAirFilter.class);
        register.add(FanBelt.class);
        register.add(FuelFilter.class);
        register.add(GeneratoryBelt.class);
        register.add(OilFilter.class);
        register.add(Part.NullPart.class);
    }

    private static Random rand = new Random(47);

    public static Part createRandomPart() {
        Class<? extends Part> partClass = register.get(rand.nextInt(register.size()));
        try {
            return partClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
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
