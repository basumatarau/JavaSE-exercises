package com.CodeHeap.enums.simpleFinitAutomataV2;

public class ControlHandles extends Input{
    String name;
    public String getName(){
        return name;
    }
    ControlHandles(String name){
        this.name = name;
    }
    @Override
    int amount() {
        throw new RuntimeException("amount() method invocation on ControlHandles instance");
    }
}
