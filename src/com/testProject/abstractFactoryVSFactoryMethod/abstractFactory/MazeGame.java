package com.testProject.abstractFactoryVSFactoryMethod.abstractFactory;

public class MazeGame implements MazeCreator {

    enum Sides {
        NORTH, SOUTH, EAST, WEST
    }

    @Override
    public Maze createMaze(AbstractFactory factory) {
        Maze maze = factory.makeMaze();
        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);

        Door door = factory.makeDoor(room1, room2);
        maze.addRoom(room1);
        maze.addRoom(room2);

        room1.setSide(Sides.NORTH, door);
        room1.setSide(Sides.SOUTH, factory.makeWall());
        room1.setSide(Sides.EAST, factory.makeWall());
        room1.setSide(Sides.WEST, factory.makeWall());

        room2.setSide(Sides.NORTH, factory.makeWall());
        room2.setSide(Sides.SOUTH, door);
        room2.setSide(Sides.EAST, factory.makeWall());
        room2.setSide(Sides.WEST, factory.makeWall());

        return maze;
    }
}
