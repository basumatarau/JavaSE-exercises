package com.codeHeap.generics.generalizedMethods.sets;

import java.util.EnumSet;
import java.util.Set;
import static com.codeHeap.generics.generalizedMethods.sets.Sets.*;

public class ColorSets {
    public static void main(String[] args) {
        Set<Colors> set1 = EnumSet.range(Colors.BRILLIANT_RED, Colors.VIRIDIAN_HUE);
        Set<Colors> set2 = EnumSet.range(Colors.CERULEAN_BLUE_HUE, Colors.BURNT_UMBER);
        System.out.println("set1: "+set1);
        System.out.println("set2: "+set2);

        EnumSet<Colors> clone = EnumSet.allOf(Colors.class).clone();
        System.out.println("union(set1, set2): "+ union(EnumSet.allOf(Colors.class), set2));
        System.out.println("intersection(set1, set2): "+ intersection(set1, set2));
        System.out.println("difference(set1, set2): "+ difference(set1, set2));
        System.out.println("complement(set1, set2): "+ complement(set1, set2));
    }
}
