package com.CodeHeap.enums.simpleFinitAutomataV2;

public class Coin extends Input{
    String name;
    int amount;
    Coin(String name, int amount){
        super(amount);
        this.name = name;
    }
}
