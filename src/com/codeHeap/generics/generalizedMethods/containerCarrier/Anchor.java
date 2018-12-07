package com.codeHeap.generics.generalizedMethods.containerCarrier;

public class Anchor {
    private static int count = 1;
    private int id = count++;
    private boolean isLost = false;
    boolean lost(){
        return isLost;
    }

}
