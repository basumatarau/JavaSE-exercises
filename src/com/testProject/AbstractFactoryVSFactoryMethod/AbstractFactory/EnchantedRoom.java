package com.testProject.AbstractFactoryVSFactoryMethod.AbstractFactory;

public class EnchantedRoom extends Room {
    EnchantedRoom(int id) {
        super(id);
    }

    @Override
    public void enter() {
        System.out.println("Enter: EnchantedRoom");
    }

}
