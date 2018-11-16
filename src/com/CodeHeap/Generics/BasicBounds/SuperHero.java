package com.CodeHeap.Generics.BasicBounds;

public class SuperHero<POWER extends SuperPower> {
    protected POWER power;
    SuperHero(POWER power){
        this.power = power;
    }
    POWER getPower(){
        return power;
    }
}
