package com.codeHeap.generics.decorator.v2;

public class Basic {
    private String value;

    public Basic() {
        value = "default string";
    }

    public Basic(String value) {
        this.value = value;
    }
    public String get(){
        return value;
    }
    public void set(String value){
        this.value = value;
    }
}
