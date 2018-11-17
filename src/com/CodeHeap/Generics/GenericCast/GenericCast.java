package com.CodeHeap.Generics.GenericCast;

public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        for (String s : "ABCDEFGHIJ".split("")) {
            strings.push(s);
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.print(strings.pop()+", ");
        }

    }
}
