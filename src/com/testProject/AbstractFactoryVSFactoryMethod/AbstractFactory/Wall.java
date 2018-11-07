package com.testProject.AbstractFactoryVSFactoryMethod.AbstractFactory;

public class Wall implements MapSite {
    @Override
    public void enter() {
        System.out.println("Enter: Wall");
    }
}
