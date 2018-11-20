package com.CodeHeap.arrays.task16_9;

public class Banana {
    boolean isPeeled;
    public static <T extends Banana> void peel(T obj){
        obj.isPeeled = true;
    }

    public static void main(String[] args) {
        Banana banana = new Banana();

        System.out.println("banana is peeled: "+banana.isPeeled);
        peel(banana);
        System.out.println("banana has been peeled: "+banana.isPeeled);
    }
}
