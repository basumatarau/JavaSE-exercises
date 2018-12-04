package com.CodeHeap.IO.Serialization;

import java.util.Random;

public class Worm {
    private static Random rand = new Random(47);
    private Data[] data = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;

    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor " + i);
        if(--i<0){
            next = new Worm(i, (char)('x'-1));
        }
    }
    public Worm(){
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return null;
        //todo

    }
}
