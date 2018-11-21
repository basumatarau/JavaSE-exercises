package com.CodeHeap.Collections.playingWithCollections01;

public class StringAddress {
    String value;

    StringAddress(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + " " + value;
    }
}
