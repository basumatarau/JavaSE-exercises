package com.CodeHeap.enums.Util;

import java.util.Random;

public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> enumInstance){
        return random(enumInstance.getEnumConstants());
    }

    public static <T> T random(T[] enumConstants) {
        return enumConstants[random.nextInt(enumConstants.length)];
    }
}
