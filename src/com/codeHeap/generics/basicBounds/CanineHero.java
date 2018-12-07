package com.codeHeap.generics.basicBounds;

public class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero <POWER> {
    public CanineHero(POWER power) {
        super(power);
    }
    void listen(){
        power.hearSubtleNoises();
    }
    void smell(){
        power.trackBySmell();
    }
}
