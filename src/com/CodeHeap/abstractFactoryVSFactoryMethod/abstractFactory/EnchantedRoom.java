package com.CodeHeap.abstractFactoryVSFactoryMethod.abstractFactory;

public class EnchantedRoom extends Room {
    EnchantedRoom(int id) {
        super(id);
    }

    @Override
    public void enter() {
        System.out.println("Enter: EnchantedRoom");
    }

}
