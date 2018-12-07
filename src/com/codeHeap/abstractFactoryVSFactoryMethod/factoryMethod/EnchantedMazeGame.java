package com.codeHeap.abstractFactoryVSFactoryMethod.factoryMethod;

public class EnchantedMazeGame extends MazeGame {

    @Override
    protected Room makeRoom(int id) {
        return new EnchantedRoom(id);
    }

    @Override
    protected Door makeDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }

    @Override
    protected Wall makeWall() {
        return new EnchantedWall();
    }
}
