package com.codeHeap.generics.interfaceHijack;

public class ComparablePet implements Comparable<ComparablePet>{
    @Override
    public int compareTo(ComparablePet comparablePet) {
        return 0;
    }
}
