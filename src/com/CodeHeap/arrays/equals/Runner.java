package com.CodeHeap.arrays.equals;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5};
        System.out.println(Arrays.equals(array1, array2));
        Holder[] array3 = {
                new Holder(1),
                new Holder(2),
                new Holder(3),
                new Holder(4),
                new Holder(5)
        };

        Holder[] array4 = {
                new Holder(1),
                new Holder(2),
                new Holder(3),
                new Holder(4),
                new Holder(5)
        };
        System.out.println(Arrays.equals(array3, array4));

        int[][] array5 = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[][] array6 = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        System.out.println(Arrays.equals(array5, array6));
        System.out.println(Arrays.deepEquals(array5, array6));

        String[][] array7 = {{"qwer","qwer","qwer"},{"qwer","qwer","qwer"},{"qwer","qwer","qwer"}};
        String[][] array8 = {{"qwer","qwer","qwer"},{"qwer","qwer","qwer"},{"qwer","qwer","qwer"}};
        System.out.println(Arrays.equals(array7, array8));
        System.out.println(Arrays.deepEquals(array7, array8));

    }
}
