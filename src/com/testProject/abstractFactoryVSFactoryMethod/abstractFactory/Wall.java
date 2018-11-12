package com.testProject.abstractFactoryVSFactoryMethod.abstractFactory;

public class Wall implements MapSite {
    @Override
    public void enter() {
        System.out.println("Enter: Wall");
    }
}
