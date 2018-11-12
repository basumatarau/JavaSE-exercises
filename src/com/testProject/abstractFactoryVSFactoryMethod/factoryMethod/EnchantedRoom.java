package com.testProject.abstractFactoryVSFactoryMethod.factoryMethod;

public class EnchantedRoom extends Room {
    EnchantedRoom(int id) {
        super(id);
    }

    @Override
    public void enter() {
        System.out.println("Enter: EnchantedRoom");
    }

}
