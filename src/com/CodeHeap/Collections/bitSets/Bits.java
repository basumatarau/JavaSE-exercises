package com.CodeHeap.Collections.bitSets;

import java.util.BitSet;
import java.util.Random;

public class Bits {
    public static void printBitSet(BitSet bitSet) {
        System.out.println("Bits: " + bitSet);
        StringBuilder result = new StringBuilder("Bit pattern: ");
        for (int i = 0; i < bitSet.size(); i++) {
            result.append(bitSet.get(i) ? "1" : "0");
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        byte bt = (byte) rand.nextInt();
        BitSet bitSet = new BitSet();
        for (int i = 7; i > 0; i--) {
            if (((1 << i) & bt) != 0) {
                bitSet.set(i);
            } else {
                bitSet.clear(i);
            }
        }
        System.out.println("byte value: " + bt);
        printBitSet(bitSet);
        short sh = (short) rand.nextInt();
        BitSet bitSet2 = new BitSet();
        for (int i = 15; i > 0; i--) {
            if (((1 << i) & sh) != 0) {
                bitSet2.set(i);
            } else {
                bitSet2.clear(i);
            }
        }
        System.out.println("short value: " + sh);
        printBitSet(bitSet2);
        int itg = rand.nextInt();
        BitSet bitSet3 = new BitSet();
        for (int i = 31; i > 0; i--) {
            if (((1 << i) & itg) != 0) {
                bitSet3.set(i);
            } else {
                bitSet3.clear(i);
            }
        }
        System.out.println("int value: " + itg);
        printBitSet(bitSet3);
        BitSet bs = new BitSet(128);
        bs.set(256);
        System.out.println(bs);
        bs.set(512);
        System.out.println(bs);
    }
}
