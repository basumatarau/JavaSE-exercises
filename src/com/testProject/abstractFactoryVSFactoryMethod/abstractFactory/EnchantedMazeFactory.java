package com.testProject.abstractFactoryVSFactoryMethod.abstractFactory;

public class EnchantedMazeFactory implements AbstractFactory {
    @Override
    public Maze makeMaze() {
        return new Maze();
    }

    @Override
    public Room makeRoom(int id) {
        return new EnchantedRoom(id);
    }

    @Override
    public Door makeDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }

    @Override
    public Wall makeWall() {
        return new EnchantedWall();
    }
}
