package com.codeHeap.collections.refernces;

public class VeryBig {
    private static final int SIZE = 100000;
    private long[] la = new long[SIZE];
    private String id;
    VeryBig(String id){
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalizing "+id);
    }

    @Override
    public String toString() {
        return id;
    }
}
