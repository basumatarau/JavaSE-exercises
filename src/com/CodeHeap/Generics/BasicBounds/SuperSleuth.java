package com.CodeHeap.Generics.BasicBounds;

public class SuperSleuth <POWER extends XRayVision> extends SuperHero<POWER>{
    public SuperSleuth(POWER power) {
        super(power);
    }
    void see(){
        power.seeThroughWalls();
    }
}
