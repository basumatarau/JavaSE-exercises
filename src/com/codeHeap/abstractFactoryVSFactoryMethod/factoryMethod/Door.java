package com.codeHeap.abstractFactoryVSFactoryMethod.factoryMethod;

public class Door implements MapSite {
    private boolean isOpen;
    protected Room room1;
    protected Room room2;

    Door(Room room1, Room room2){
        this.room1 = room1;
        this.room2 = room2;
        isOpen = true;
    }

    @Override
    public void enter() {
        System.out.println("Enter: Door from" +room1+" to"+room2);
    }
}
