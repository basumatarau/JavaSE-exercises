package com.CodeHeap.enums.usingInterfaces;

public class Meal {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("Randomized order #" + (i+1));
            for (Course course : Course.values()) {
                System.out.println(course.randomSelection());
            }
        }
    }
}
