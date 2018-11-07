package com.testProject.AbstractFactoryVSFactoryMethod.FactoryMethod;

public class Wall implements MapSite {
    @Override
    public void enter() {
        System.out.println("Enter: Wall");
    }
}
