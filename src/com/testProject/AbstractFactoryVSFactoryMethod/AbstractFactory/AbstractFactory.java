package com.testProject.AbstractFactoryVSFactoryMethod.AbstractFactory;

public interface AbstractFactory {
    Maze makeMaze();
    Room makeRoom(int id);
    Door makeDoor(Room room1, Room room2);
    Wall makeWall();
}
