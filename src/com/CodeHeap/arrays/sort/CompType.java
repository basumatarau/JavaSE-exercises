package com.CodeHeap.arrays.sort;

import com.CodeHeap.arrays.CountingGenerator.Generator;

import java.util.Random;

public class CompType implements Comparable<CompType> {

    int i;
    int j;
    private static int counter = 1;

    CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        String result = "[i=" + i + ", j=" + j + "]";
        if (counter++ % 3 == 0) {
            result += '\n';
        }
        return result;
    }

    @Override
    public int compareTo(CompType compType) {
        return this.i < compType.i ? -1 : (this.i == compType.i ? 0 : 1);
    }

    private static Random random = new Random(47);
    public static Generator<CompType> getGenerator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(random.nextInt(100), random.nextInt(100));
            }
        };
    }
}
