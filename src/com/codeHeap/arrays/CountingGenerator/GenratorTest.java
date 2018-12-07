package com.codeHeap.arrays.CountingGenerator;

public class GenratorTest {
    static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> aClass : surroundingClass.getClasses()) {
            System.out.print(aClass.getSimpleName() + ": ");
            String delimiter = "";
            try {
                Generator<?> genInstance = (Generator<?>) aClass.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(delimiter + genInstance.next());
                    delimiter = ", ";
                }
                System.out.println();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
        test(RandomGenerator.class);
    }
}
