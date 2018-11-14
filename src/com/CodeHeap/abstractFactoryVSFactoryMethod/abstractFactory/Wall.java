package com.CodeHeap.abstractFactoryVSFactoryMethod.abstractFactory;

public class Wall implements MapSite {
    @Override
    public void enter() {
        System.out.println("Enter: Wall");
    }
}
