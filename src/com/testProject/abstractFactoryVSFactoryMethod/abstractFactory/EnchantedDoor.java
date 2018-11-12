package com.testProject.abstractFactoryVSFactoryMethod.abstractFactory;

public class EnchantedDoor extends Door {
    EnchantedDoor(Room room1, Room room2) {
        super(room1, room2);
    }

    @Override
    public void enter() {
        System.out.println("Enter: EnchantedDoor from" +super.room1+" to "+super.room2);
    }
}
