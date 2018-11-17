package com.CodeHeap.Generics.InterfaceHijack;

public class ComparablePet implements Comparable<ComparablePet>{
    @Override
    public int compareTo(ComparablePet comparablePet) {
        return 0;
    }
}
