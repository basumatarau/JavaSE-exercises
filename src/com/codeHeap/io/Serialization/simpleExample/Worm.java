package com.codeHeap.io.Serialization.simpleExample;

import java.io.Serializable;
import java.util.Random;

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] data = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;

    private char c;

    public Worm(int i, char x) {
        c = x;
        System.out.println("Worm constructor " + i);
        if(--i>0){
            next = new Worm(i, (char)(c+1));
        }
    }
    public Worm(){
        System.out.println("Default constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(c);
        result.append("(");
        for (Data datum : data) {
            result.append(datum);
        }
        result.append(")");
        if(next!=null){
            result.append(next);
        }
        return result.toString();
    }
}
