package com.codeHeap.threads.atomicity;

public class CircularSet {
    private int[] array;
    private int index = 0;
    private int len;

    CircularSet(int len){
        array = new int[len];
        this.len = len;
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }

    synchronized void add(int x){
        array[index] = x;
        index = ++index % len;
    }

    synchronized boolean contains(int x){
        for (int i = 0; i < len; i++) {
            if(array[i]==x){
                return true;
            }
        }
        return false;
    }
}
