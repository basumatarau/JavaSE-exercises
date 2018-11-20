package com.CodeHeap.arrays.task16_1;

import java.util.Arrays;

public class ArrayOptions {

    static void someMethod(Integer[] arrayInteger){
        System.out.print(Arrays.toString(arrayInteger));
    }

    public static void main(String[] args) {
        //someMethod({1,2,3,4,5});
        someMethod(new Integer[]{1,2,3,4,5});
        int[] a = null;
        a = new int[]{1,2,3,4,5};
        int[] b = {1,2,3,4,5};
        //b = {6,7,8};
    }
}
