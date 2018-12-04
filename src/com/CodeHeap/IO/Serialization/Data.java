package com.CodeHeap.IO.Serialization;

public class Data {
    private int n;
    public Data(int n){
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

