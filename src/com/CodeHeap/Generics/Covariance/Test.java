package com.CodeHeap.Generics.Covariance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<? extends Number> intList = new ArrayList<>(Arrays.asList(1,2,3));
        for (Number number : intList) {
            System.out.println(number);
        }

        //operator '+' is not overloaded for instances of Number:
        //System.out.println(intList.get(0) + intList.get(1));
        //doesn't compile...

        List<? super Number> intList2 = new ArrayList<>(Arrays.asList(1,2,3));
        intList2.add(40L);
        intList2.add(49.99F);
        intList2.add(99.99D);
        for (Object o : intList2) {
            System.out.println(o);
        }
    }
}
