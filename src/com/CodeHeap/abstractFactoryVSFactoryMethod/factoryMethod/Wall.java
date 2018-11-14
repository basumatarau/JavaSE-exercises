package com.CodeHeap.abstractFactoryVSFactoryMethod.factoryMethod;

public class Wall implements MapSite {
    @Override
    public void enter() {
        System.out.println("Enter: Wall");
    }
}
