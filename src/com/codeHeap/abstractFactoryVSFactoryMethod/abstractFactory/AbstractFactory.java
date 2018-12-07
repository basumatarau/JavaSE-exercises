package com.codeHeap.abstractFactoryVSFactoryMethod.abstractFactory;

public interface AbstractFactory {
    Maze makeMaze();
    Room makeRoom(int id);
    Door makeDoor(Room room1, Room room2);
    Wall makeWall();
}
