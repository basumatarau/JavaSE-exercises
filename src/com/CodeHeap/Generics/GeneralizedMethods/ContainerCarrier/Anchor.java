package com.CodeHeap.Generics.GeneralizedMethods.ContainerCarrier;

public class Anchor {
    private static int count = 1;
    private int id = count++;
    private boolean isLost = false;
    boolean lost(){
        return isLost;
    }

}
