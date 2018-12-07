package com.codeHeap.enums.doubleDispatch.roShamBo2;

import com.codeHeap.enums.util.Enums;

public class RoShamBoUtil {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + " : " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rps, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rps), Enums.random(rps));
        }
    }

}
