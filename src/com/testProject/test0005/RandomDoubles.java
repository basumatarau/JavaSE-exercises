package com.testProject.test0005;

import java.util.Random;

public class RandomDoubles {
    private int count;
    private static Random rand = new Random(47);

    public double next() {
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 10; i++) {
            System.out.println(rd.next());
        }
    }
}
